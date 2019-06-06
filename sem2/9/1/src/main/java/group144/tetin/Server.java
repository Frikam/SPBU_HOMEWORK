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

    public Server(int port) throws IOException {
        game = new Game();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        socketChannel = serverSocketChannel.accept();
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
        ByteBuffer clientTurn = ByteBuffer.allocate(Encoder.CLIENT_TURN_LENGTH);
        socketChannel.read(clientTurn);
        coords = Encoder.decodeClientTurn(clientTurn);
        game.turn(coords[0], coords[1]);
        ByteBuffer answer = Encoder.encodeShort(game.state());
        socketChannel.write(answer);

        return coords;
    }
}
