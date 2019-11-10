public class Ground {
    private static final int WIDTH_OF_WINDOW = 940;

    public static int coordinatesCannonAfterMovingRight(int x) {
        if (x + Config.WIDTH_OF_CANNON <= WIDTH_OF_WINDOW) {
            return x + 2;
        }
        return x;
    }

    public static int coordinatesCannonAfterMovingLeft(int x) {
        if (x > 0) {
            return x - 2;
        }
        return x;
    }

    public static boolean isOutFromBounds(int x, int y) {
        return (y > Config.Y_COORDINATE_OF_GROUND || x > WIDTH_OF_WINDOW);
    }
}
