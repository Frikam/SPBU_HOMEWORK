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

    public void makeShoot(int angle, int positionOfBulletX, int positionOfBulletY) {
        isFly = true;
        currentTime = 0;
        this.angle = -angle + 35;
        this.positionOfBulletX = positionOfBulletX + 25;
        this.positionOfBulletY = positionOfBulletY - 3;
    }

    public boolean isFly() {
        return isFly;
    }

    public void drawBullet(Graphics g) {
        if (!isFly) {
            return;
        }

        currentX = (int) (SPEED * Math.cos(Math.toRadians(angle)) * currentTime);
        currentY = (int) (-SPEED * Math.sin(Math.toRadians(angle)) * currentTime
                + GRAVITIONAL_CONSTANT * currentTime * currentTime);

        if (currentY + positionOfBulletY > Config.Y_COORDINATE_OF_GROUND
                || currentX + positionOfBulletX > Config.WIDTH_OF_WINDOW ) {
            isFly = false;
            return;
        }

        currentTime += 1;

        g.drawImage(bullet, positionOfBulletX + currentX, positionOfBulletY + currentY, null);
    }
}
