package group144.tetin;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.function.Consumer;

public abstract class Controller {
    @FXML
    Label text;
    String me;
    String opponent;
    Button[][] buttons;

    Adapter game;
    public void clicked(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        try {
            if (buttonWasPressed(button)) {
                return;
            }
            int[] coords = getLocation(button);
            game.turn(coords[0], coords[1]);
            button.setText(me);
            setDisableAll(true);

            Runnable waitOpponent = () -> {
                try {
                    int[] location = game.opponentTurn();
                    Button opponentTurn = buttons[location[0]][location[1]];
                    Platform.runLater(() -> {
                        opponentTurn.setText(opponent);
                        setDisableAll(false);
                        checkGameState();
                        changeText();
                    });
                } catch (IOException e) {
                    System.out.println("Lost connection");
                    return;
                }
            };

            Thread thread = new Thread(waitOpponent);
            thread.start();
            checkGameState();
            changeText();
        }
        catch (Exception e) {
            sendMessage("You have some problems with connection", button);
            System.out.println("Lost connection");
            return;
        }
    }

    private boolean buttonWasPressed(Button button) {
        return !button.getText().equals("");
    }

    public void checkGameState() {
        if (game.state() != "PLAYING") {
            endGame(game.state());
            setDisableAll(true);
        }
    }

    public void changeText() {
        if (text.getText().equals("Now turn X")) {
            text.setText("Now turn O");
            return;
        }

        text.setText("Now turn X");
    }

    /** A method that show window with result */
    private void endGame(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText("Game result : " + winner);
        alert.showAndWait();
        Stage stage = (Stage) button_0_0.getScene().getWindow();
        stage.close();
    }

    private int[] getLocation(Button button) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (button.equals(buttons[i][j])) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }

    private void sendMessage(String message, Button button) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setHeaderText(message);
        alert.showAndWait();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    protected void setDisableAll(boolean b) {
        forAllButtons(button -> button.setDisable(b));
    }

    @FXML
    Button button_0_0;
    @FXML
    Button button_0_1;
    @FXML
    Button button_0_2;

    @FXML
    Button button_1_0;
    @FXML
    Button button_1_1;
    @FXML
    Button button_1_2;

    @FXML
    Button button_2_0;
    @FXML
    Button button_2_1;
    @FXML
    Button button_2_2;


    private void forAllButtons(Consumer<Button> consumer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                consumer.accept(buttons[i][j]);
            }
        }
    }

    protected Button getButtonByLocation(int row, int collum) {
        return buttons[row][collum];
    }
}
