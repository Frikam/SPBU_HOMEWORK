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

    /** A method that called every 15 millisecond and checks need to paints components or no */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (needToPaintComponents || cannon.bulletIsFly()) {
            repaint();
            needToPaintComponents = false;
        }
    }

    /** A method that paints background and cannon */
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

    /** A class that represent key listener */
    private class KeyListener extends KeyAdapter {
        /** A method that checks what button was pressed */
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
