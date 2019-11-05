import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class GameController extends JPanel implements ActionListener {
    private Image backGround;
    private Timer timer;
    Cannon cannon;
    private boolean needToPaintComponents = true;

    GameController() {
        cannon = new Cannon();
        loadImages();
        addKeyListener(new KeyListener());
        timer = new Timer(15, this);
        timer.start();
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (needToPaintComponents || cannon.bulletIsFly()) {
            repaint();
            needToPaintComponents = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backGround, 0, 0, this);
        cannon.paintComponent(g);

    }

    private void loadImages() {
        try {
            backGround = ImageIO.read(new File("src/main/resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            needToPaintComponents = true;
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                cannon.goRight();
            } else if (key == KeyEvent.VK_LEFT) {
                cannon.goLeft();
            } else if (key == KeyEvent.VK_DOWN) {
                cannon.pushDown();
            } else if (key == KeyEvent.VK_UP) {
                cannon.pushUp();
            } else if (key == KeyEvent.VK_ENTER) {
                cannon.shoot();
            }
        }
    }
}
