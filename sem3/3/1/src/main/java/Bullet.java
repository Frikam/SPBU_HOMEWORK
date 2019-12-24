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
    private boolean isFlying  = false;
    private double currentTime = 0;
    private final double GRAVITIONAL_CONSTANT = 0.1;
    private final double SPEED = 8;
    private Ground ground;

    Bullet() {
        try {
            bullet = ImageIO.read(new File("src/main/resources/cannonBall.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить модель пули," +
                    " проверьте что она лежат в папке resources с названием cannonBall.png");
        }
        ground = new Ground();
    }

    public void prepareForShooting(int angle, int positionOfCannonX, int positionOfCannonY) {
        isFlying = true;
        currentTime = 0;
        this.angle = -angle + Config.START_ANGLE;
        this.positionOfBulletX = positionOfCannonX + 27 + (int) (Math.sin(Math.toRadians(angle))* 35); // 27 is the difference between the width of a cannon and a bullet
        this.positionOfBulletY = positionOfCannonY - 8 - (int) (Math.cos(Math.toRadians(angle)) * 12); // 8  is difference between the height of a cannon and a bullet
    }

    public boolean isFlying() {
        return isFlying ;
    }

    public void paintBullet(Graphics g) {
        if (!isFlying ) {
            return;
        }

        calculateCoordinatesOfBullet();
        if (ground.isOutFromBounds(currentX + positionOfBulletX, currentY + positionOfBulletY) ||
                ground.isBulletInMountain(currentX + positionOfBulletX, currentY + positionOfBulletY)) {
            isFlying = false;
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
