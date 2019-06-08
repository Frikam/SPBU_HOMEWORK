package group144.tetin;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface Adapter {
    /**
     * A Method makes turn
     *
     * @param row first coordinate of pos
     * @param column second coordinate of pos
     * @throws IOException throws when it's something wrong with SocketServerChannel - SocketChannel connection
     */
    void turn(int row, int column) throws IOException;

    /**
     * A Method returns state of game
     */
    String state();

    /**
     * A Method wait opponent turn
     * @return coord's array {row, column}
     * @throws IOException throws when it's something wrong with SocketServerChannel - SocketChannel connection
     */
    int[] opponentTurn() throws IOException;

    /** A method send message about disconnect to second player */
    void sendMessageAboutDisconnect() throws IOException;

    /** A method that tells us was the second player disconnected or no */
    boolean hasPlayerDisconnected();
}
