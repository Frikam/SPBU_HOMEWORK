package group144.tetin;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server implements Adapter {
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private Game game;
    private boolean playerDisconnected;

    public Server(int port) throws IOException {
        playerDisconnected = false;
        game = new Game();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        socketChannel = serverSocketChannel.accept();
    }

    @Override
    public void sendMessageAboutDisconnect() throws IOException {
        ByteBuffer serverTurn = ByteBuffer.allocate(Encoder.PLAYER_TURN_LENGTH);
        serverTurn.put((byte) 0);
        serverTurn.put((byte) 0);
        serverTurn.put((byte) -1);
        socketChannel.write(serverTurn);
    }

    @Override
    public boolean hasPlayerDisconnected() {
        return playerDisconnected;
    }

    @Override
    public void turn(int row, int column) throws IOException {
        game.turn(row, column);
        ByteBuffer byteBuffer = Encoder.encode(row, column, game.state());
        socketChannel.write(byteBuffer);
    }

    @Override
    public String state() {
        return game.state();
    }

    @Override
    public int[] opponentTurn() throws IOException {
        int[] coords;
        ByteBuffer clientTurn = ByteBuffer.allocate(Encoder.PLAYER_TURN_LENGTH);
        socketChannel.read(clientTurn);
        coords = Encoder.decodeClientTurn(clientTurn);
        String state = Encoder.getState(clientTurn);
        if (state.equals("EXCEPTION")) {
            playerDisconnected = true;
            return new int[] {0, 0};
        }
        game.turn(coords[0], coords[1]);
        ByteBuffer answer = Encoder.encodeShort(game.state());
        socketChannel.write(answer);

        return coords;
    }
}
