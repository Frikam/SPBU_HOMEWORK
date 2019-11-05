public class Mountains {
    private static final int[] START_X = new int[] {0, 514};
    private static final int[] END_X = new int[] {197, 867};
    private static final int[] TOP_X = new int[] {0, 690};

    public static boolean standsOnMountain(int cannonCoordinatesX) {
        int length = START_X.length;
        for (int i = 0; i < length; i++) {
            if (cannonCoordinatesX >= START_X[i] && cannonCoordinatesX <= END_X[i]) {
                return true;
            }
        }
        return false;
    }

    public static  boolean isLeftFromTop(int cannonCoordinatesX) {
        if (cannonCoordinatesX <= END_X[0]) {
            return false;
        }
        return cannonCoordinatesX <= TOP_X[1];
    }

}
