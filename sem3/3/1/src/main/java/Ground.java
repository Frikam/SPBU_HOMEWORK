public class Ground {
    private final int WIDTH_OF_WINDOW = 940;
    private Mountains mountains;

    Ground() {
        mountains = new Mountains();
    }

    public int coordinateXCannonAfterMovingRight(int x) {
        if (x + Config.WIDTH_OF_CANNON <= WIDTH_OF_WINDOW) {
            return x + 2;
        }
        return x;
    }

    public int coordinateXCannonAfterMovingLeft(int x) {
        if (x > 1) {
            return x - 2;
        }
        return x;
    }

    public boolean isOutFromBounds(int x, int y) {
        return (y > Config.Y_COORDINATE_OF_GROUND || x > WIDTH_OF_WINDOW);
    }

    public int coordinateYCannonAfterMovingRight(int x, int y) {
        if (mountains.standsOnMountain(x)) {
            return mountains.coordinatesCannonAfterMovingRight(x, y);
        }
        return y;
    }

    public int coordinateYCannonAfterMovingLeft(int x, int y) {
        if (mountains.standsOnMountain(x)) {
            return mountains.coordinatesCannonAfterMovingLeft(x, y);
        }
        return y;
    }
}
