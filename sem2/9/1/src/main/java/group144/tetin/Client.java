package group144.tetin;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client implements Adapter {
    private SocketChannel socketChannel;
    private String state;
    private boolean playerDisconnected;

    public Client(int port) throws IOException {
        playerDisconnected = false;
        socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(port));
    }

    @Override
    public void sendMessageAboutDisconnect() throws IOException {
        ByteBuffer serverTurn = ByteBuffer.allocate(Encoder.PLAYER_TURN_LENGTH);
        serverTurn.put((byte) 0);
        serverTurn.put((byte) 0);
        serverTurn.put((byte) -1);
        socketChannel.write(serverTurn);
        socketChannel.read(serverTurn);
        state = "EXCEPTION";
    }

    @Override
    public boolean hasPlayerDisconnected() {
        return playerDisconnected;
    }

    @Override
    public void turn(int row, int column) throws IOException {
        ByteBuffer clientTurn = Encoder.encode(row, column, state);
        socketChannel.write(clientTurn);
        ByteBuffer answer = ByteBuffer.allocate(Encoder.SHORT_LENGTH);
        socketChannel.read(answer);
        state = Encoder.getStateShort(answer);
    }

    @Override
    public String state() {
        return state;
    }

    @Override
    public int[] opponentTurn() throws IOException {
        ByteBuffer serverTurn = ByteBuffer.allocate(Encoder.PLAYER_TURN_LENGTH);
        socketChannel.read(serverTurn);
        state = Encoder.getState(serverTurn);
        int[] coords = Encoder.getServerTurn(serverTurn);

        if (state.equals("EXCEPTION")) {
            playerDisconnected = true;
            return new int[] {0, 0};
        }

        return coords;
    }
}
