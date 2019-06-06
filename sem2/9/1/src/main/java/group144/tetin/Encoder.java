package group144.tetin;

import java.nio.ByteBuffer;

public class Encoder {
    public static final int SERVER_TURN_LENGTH = 3;
    public static final int CLIENT_TURN_LENGTH = 2;
    public static final int SHORT_LENGTH = 1;

    /**
     * Method generate ByteBuffer with info about: your last try to turn, state
     * it use on server to send result to client
     */
    public static ByteBuffer encodeShort(String state) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(SHORT_LENGTH);
        switch (state) {
            case "PLAYING":
                byteBuffer.put((byte) 0);
                break;
            case "X_WON":
                byteBuffer.put((byte) 1);
                break;
            case "O_WON":
                byteBuffer.put((byte) 2);
                break;

            default:
                byteBuffer.put((byte) 3);
        }

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
            case 0:
                return "PLAYING";
            case 1:
                return "X_WON";
            case 2:
                return "O_WON";
            default: return "DRAW";
        }
    }

    /**
     * Method generate byteBuffer with info about last client's turn
     * it use on client to sent this byteBuffer to server
     *
     * @param turnX row
     * @param turnY column
     * @return byteBuffer that you can decode
     */
    public static ByteBuffer clientTurn(int turnX, int turnY) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        byteBuffer.put((byte) turnX);
        byteBuffer.put((byte) turnY);

        byteBuffer.flip();

        return byteBuffer;
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
        switch (state) {
            case "PLAYING":
            byteBuffer.put((byte) 0);
            break;
            case "X_WON":
                byteBuffer.put((byte) 1);
                break;
            case "O_WON":
                byteBuffer.put((byte) 2);
                break;

            default:
                byteBuffer.put((byte) 3);
        }

        byteBuffer.flip();

        return byteBuffer;
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
            case 0:
                return "PLAYING";
            case 1:
                return "X_WON";
            case 2:
                return "O_WON";
            default: return "DRAW";
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
