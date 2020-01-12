package group144.tetin;

import java.nio.ByteBuffer;

public class Encoder {
    public static final int PLAYER_TURN_LENGTH = 3;
    public static final int SHORT_LENGTH = 1;

    /**
     * Method generate ByteBuffer with info about: your last try to turn, state
     * it use on server to send result to client
     */
    public static ByteBuffer encodeShort(String state) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(SHORT_LENGTH);
        byteBuffer.put(getEncodedState(state));
        byteBuffer.flip();
        return byteBuffer;
    }

    /**
     * Method decode byteBuffer that was encoded as Short
     * it use on client
     *
     * @param byteBuffer encoded byteBuffer
     * @return info about game's state
     */
    public static String getStateShort(ByteBuffer byteBuffer) {
        switch (byteBuffer.get(0)) {
            case 1:
                return "PLAYING";
            case 2:
                return "X_WON";
            case 3:
                return "O_WON";
            case 4:
                return "DRAW";
            default: return "EXCEPTION";
        }
    }

    /**
     * Method decode byteBuffer that was encoded as ClientTurn byteBuffer
     * use on server
     *
     * @param byteBuffer encoded byteBuffer
     * @return int array{row, column}
     */
    public static int[] decodeClientTurn(ByteBuffer byteBuffer) {
        return new int[]{byteBuffer.get(0), byteBuffer.get(1)};
    }

    /**
     * Method generate byteBuffer with server's turn and game's state
     * use on server to send to client
     *
     * @param lastTurnX row
     * @param lastTurnY column
     * @param state game's state
     * @return encoded byteBuffer
     */
    public static ByteBuffer encode(int lastTurnX, int lastTurnY, String state) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        byteBuffer.put((byte) lastTurnX);
        byteBuffer.put((byte) lastTurnY);
        byteBuffer.put(getEncodedState(state));
        byteBuffer.flip();

        return byteBuffer;
    }

    private static byte getEncodedState(String state) {
        switch (state) {
            case "PLAYING":
                return ((byte) 1);
            case "X_WON":
                return ((byte) 2);
            case "O_WON":
                return ((byte) 3);
            case "DRAW":
                return ((byte) 4);
            default:
                return ((byte) 5);
        }
    }

    /**
     * Method decode encoded byteBuffer as {x, y, state}
     * use on client
     *
     * @param byteBuffer encoded buffer
     * @return game's state
     */
    public static String getState(ByteBuffer byteBuffer) {
        switch (byteBuffer.get(2)) {
            case 1:
                return "PLAYING";
            case 2:
                return "X_WON";
            case 3:
                return "O_WON";
            case 4:
                return "DRAW";
            default:
                return "EXCEPTION";
        }
    }

    /**
     * Method decode encoded byteBuffer as {x, y, state}
     * use on client
     *
     * @param byteBuffer encoded buffer
     * @return int array{row, column}
     */
    public static int[] getServerTurn(ByteBuffer byteBuffer) {
        return new int[]{byteBuffer.get(0), byteBuffer.get(1)};
    }

}
