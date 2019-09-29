package group144.tetin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerServer extends Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Server is on, waiting client");
        me = "X";
        opponent = "O";
        buttons = new Button[][] {{button_0_0, button_0_1, button_0_2}, {button_1_0, button_1_1, button_1_2}, {button_2_0, button_2_1, button_2_2}};
        Runnable waitConnection = () -> {
            try {
                game = new Server(8888);
                setDisableAll(false);
                System.out.println("Connected, game is on");
            } catch (IOException e) {
                System.out.println("You run several servers, try again");
            }
        };

        Thread wait = new Thread(waitConnection);
        setDisableAll(true);
        wait.start();
    }
}
