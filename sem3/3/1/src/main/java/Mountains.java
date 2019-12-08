/** A class that represent the mountains */
public class Mountains {
    /** Coordinates of mountains */
    private final int[] START_X = new int[] {0, 514};
    private final int[] END_X = new int[] {197, 867};
    private final int[] TOP_X = new int[] {0, 690};
    private final int LEFT_COORDINATE_OF_BOUND_FOR_WHEEL = 20;
    private boolean cannonIsAtBound = false;

    /** A method that checks cannon on mountain or no */
    public boolean standsOnMountain(int coordinatesX) {
        int length = START_X.length;
        for (int i = 0; i < length; i++) {
            if (coordinatesX >= START_X[i] && coordinatesX <= END_X[i]  ) {
                return true;
            }
        }
        return false;
    }

    /** A method that checks cannon left from top or no */
    public boolean isLeftFromTop(int cannonCoordinatesX) {
        if (cannonCoordinatesX <= END_X[0]) {
            return false;
        }
        return cannonCoordinatesX <= TOP_X[1];
    }

    public int coordinatesCannonAfterMovingLeft(int x, int y) {
        if (x == LEFT_COORDINATE_OF_BOUND_FOR_WHEEL) {
            if (!cannonIsAtBound) {
                cannonIsAtBound = true;
                return y - 2;
            } else {
                return y;
            }
        }
        cannonIsAtBound = false;
        if (isLeftFromTop(x)) {
            return y + 2;
        } else {
            return y - 2;
        }
    }

    public int coordinatesCannonAfterMovingRight(int x, int y) {
        if (isLeftFromTop(x)) {
            return y - 2;
        } else {
            return y + 2;
        }
    }
}
