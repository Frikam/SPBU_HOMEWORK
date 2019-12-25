import java.util.Hashtable;

/** A class that represent the mountains */
public class Mountains {
    /** Coordinates of mountains */
    private final int[] START_X = new int[] {0, 514};
    private final int[] END_X = new int[] {197, 867};
    private final int[] TOP_X = new int[] {0, 690};
    private final int[] TOP_Y = new int[] {262};
    private final int LEFT_COORDINATE_OF_BOUND_FOR_WHEEL = 20;
    private boolean cannonIsAtBound = false;
    private Hashtable<Integer, Integer> coordinatesOfFirstMountain = new Hashtable<>();
    private Hashtable<Integer, Integer> coordinatesOfSecondMountain = new Hashtable<>();

    Mountains() {
        getMountainsCoordinates();
    }

    private void getMountainsCoordinates() {
        int y = 440;
        boolean isLeftPartOfMountain = true;
        for (int x = 497; x <= 849; x++) {
            coordinatesOfSecondMountain.put(x, y);
            if (isLeftPartOfMountain) {
                y--;
            } else {
                y++;
            }
            if (y <= TOP_Y[0]) {
                isLeftPartOfMountain = false;
            }
        }

        y = 262;
        for (int x = 1; x <= 179; x++) {
            coordinatesOfFirstMountain.put(x, y);
            y++;
        }
    }
    /** A method that checks cannon on mountain or no */
    public boolean standsOnMountain(int coordinatesX) {
        int length = START_X.length;
        for (int i = 0; i < length; i++) {
            if (coordinatesX >= START_X[i] && coordinatesX <= END_X[i]) {
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

    public boolean isBulletInMountain(int x, int y) {
        if (coordinatesOfFirstMountain.containsKey(x)) {
            return coordinatesOfFirstMountain.get(x) <= y;
        }
        if (coordinatesOfSecondMountain.containsKey(x)) {
            return coordinatesOfSecondMountain.get(x) <= y;
        }

        return false;
    }
}
