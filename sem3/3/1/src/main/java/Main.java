import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Cannon");

        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(940, 590);
        window.add(new GameController());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

}
