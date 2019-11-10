/** A class that represent the mountains */
public class Mountains {
    /** Coordinates of mountains */
    private static final int[] START_X = new int[] {0, 514};
    private static final int[] END_X = new int[] {197, 867};
    private static final int[] TOP_X = new int[] {0, 690};

    /** A method that checks cannon on mountain or no */
    public static boolean standsOnMountain(int coordinatesX) {
        int length = START_X.length;
        for (int i = 0; i < length; i++) {
            if (coordinatesX >= START_X[i] && coordinatesX <= END_X[i]  ) {
                return true;
            }
        }
        return false;
    }

    /** A method that checks cannon left from top or no */
    public static boolean isLeftFromTop(int cannonCoordinatesX) {
        if (cannonCoordinatesX <= END_X[0]) {
            return false;
        }
        return cannonCoordinatesX <= TOP_X[1];
    }

    public static int coordinatesCannonAfterMovingLeft(int x, int y) {
        if (isLeftFromTop(x)) {
            return y + 2;
        } else {
            return y - 2;
        }
    }

    public static int coordinatesCannonAfterMovingRight(int x, int y) {
        if (isLeftFromTop(x)) {
            return y - 2;
        } else {
            return y + 2;
        }
    }
}
