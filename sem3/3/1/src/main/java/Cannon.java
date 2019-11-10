import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cannon {
    private Image cannonImage;
    private Image wheelImage;
    private Bullet bullet;
    private int wheelWidth;
    private int x = Config.START_X_COORDINATE_OF_CANNON;
    private int y = Config.Y_COORDINATE_OF_GROUND;
    private int rotationAngle = 0;

    Cannon() {
        loadImage();
        wheelWidth = wheelImage.getWidth(null);
        bullet = new Bullet();
    }

    /** A method that moves cannon to the left */
    public void goLeft() {
        x = Ground.coordinatesCannonAfterMovingLeft(x);
        int wheelCoordinateX = x + 7 + wheelWidth / 2;

        if (Mountains.standsOnMountain(wheelCoordinateX)) {
            y = Mountains.coordinatesCannonAfterMovingLeft(wheelCoordinateX, y);
        }
    }

    /** A method that moves cannon to the right */
    public void goRight() {
        int wheelCoordinateX = x + 7 + wheelWidth / 2;
        if (Mountains.standsOnMountain(wheelCoordinateX)) {
            y = Mountains.coordinatesCannonAfterMovingRight(wheelCoordinateX, y);
        }
        x = Ground.coordinatesCannonAfterMovingRight(x);
    }

    /** A method that push up cannon */
    public void pushUp() {
        if (rotationAngle > Config.MAX_ANGLE) {
            rotationAngle--;
        }
    }

    /** A method that push down cannon */
    public void pushDown() {
        if (rotationAngle < Config.MIN_ANGLE) {
            rotationAngle++;
        }
    }

    /** A method that give coordinates of cannon and angle to bullet */
    public void shoot() {
        if (!bulletIsFly()) {
            bullet.prepareForShooting(rotationAngle, getX(), getY());
        }
    }

    /** A method that checks bullet if fly or no */
    public boolean bulletIsFly() {
        return bullet.isFly();
    }

    /** A method that paints cannon */
    public void paintComponent(Graphics g) {
        drawRotation(g);
        bullet.paintBullet(g);
        g.drawImage(wheelImage, getX() + 9,getY() + 14, null);
    }

    /** A method that rotate cannon */
    public void drawRotation(Graphics g) {
        BufferedImage image = (BufferedImage) cannonImage;
        double locationX = image.getWidth() / 2;
        double locationY = image.getHeight() / 2;

        AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(rotationAngle), locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g.drawImage(op.filter(image, null), getX(), getY(), null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void loadImage() {
        try {
            cannonImage = ImageIO.read(new File("src/main/resources/cannon.png"));
            wheelImage = ImageIO.read(new File("src/main/resources/wheel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
