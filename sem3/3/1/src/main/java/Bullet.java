import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bullet {
    private Image bullet;
    private int angle;
    private int currentX;
    private int currentY;
    private int positionOfBulletX;
    private int positionOfBulletY;
    private boolean isFly = false;
    private double currentTime = 0;
    private final double GRAVITIONAL_CONSTANT = 0.1;
    private final double SPEED = 8;

    Bullet() {
        try {
            bullet = ImageIO.read(new File("src/main/resources/cannonBall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void prepareForShooting(int angle, int positionOfCannonX, int positionOfCannonY) {
        isFly = true;
        currentTime = 0;
        this.angle = -angle + Config.START_ANGLE;
        this.positionOfBulletX = positionOfCannonX + 25; // 25 is the difference between the width of a cannon and a bullet
        this.positionOfBulletY = positionOfCannonY - 3; // 3 is difference between the height of a cannon and a bullet
    }

    public boolean isFly() {
        return isFly;
    }

    public void paintBullet(Graphics g) {
        if (!isFly) {
            return;
        }

        calculateCoordinatesOfBullet();
        if (Ground.isOutFromBounds(currentX + positionOfBulletX, currentY + positionOfBulletY)) {
            isFly = false;
            return;
        }
        g.drawImage(bullet, positionOfBulletX + currentX, positionOfBulletY + currentY, null);
    }

    /** A method that calculates coordinates of bullet that fly on parabola */
    private void calculateCoordinatesOfBullet() {
        currentX = (int) (SPEED * Math.cos(Math.toRadians(angle)) * currentTime);
        currentY = (int) (-SPEED * Math.sin(Math.toRadians(angle)) * currentTime
                + GRAVITIONAL_CONSTANT * currentTime * currentTime);
        currentTime += 1;
    }
}
