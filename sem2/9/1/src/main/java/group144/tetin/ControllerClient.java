package group144.tetin;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClient extends Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        me = "O";
        opponent = "X";
        buttons = new Button[][] {{button_0_0, button_0_1, button_0_2}, {button_1_0, button_1_1, button_1_2}, {button_2_0, button_2_1, button_2_2}};
        setDisableAll(true);
        Runnable waitConnection = () -> {
            try {
                game = new Client(8888);
                System.out.println("Game is on");

                int[] opponentTurn;
                opponentTurn = game.opponentTurn();

                Platform.runLater(() -> {
                    Button button = super.getButtonByLocation(opponentTurn[0], opponentTurn[1]);

                    if (game.hasPlayerDisconnected()) {
                        showMessageAboutDisconnect();
                    }

                    button.setText(opponent);
                    setDisableAll(false);
                    changeText();
                });
            } catch (IOException e) {
                System.out.println("Run Server first");
                return;
            }
        };
        Thread wait = new Thread(waitConnection);
        wait.start();

    }
}
