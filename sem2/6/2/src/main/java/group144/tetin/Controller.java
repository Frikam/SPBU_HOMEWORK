package group144.tetin;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private Button[][] buttons;

    private String[][] textOnButtons;

    private String textOnButton;

    private TicTakToe ticTakToe = new TicTakToe();

    private int numberOfPressedButtons;

    /** A method that realize press on button */
    public void pressOnButton(ActionEvent event) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (event.getSource().equals(buttons[row][column])) {
                    if ("".equals(buttons[row][column].getText())) {
                        buttons[row][column].setText(textOnButton);
                        textOnButtons[row][column] = textOnButton;
                        nextTurn();
                        changeText();
                        numberOfPressedButtons++;
                        if (ticTakToe.isAnybodyWin(textOnButtons)) {
                            endGame(buttons[row][column].getText());
                            return;
                        }
                    }
                }
            }
        }

        if (numberOfPressedButtons == buttons.length * buttons.length) {
            endGame("Nobody");
        }
    }

    /** A method that show window with result */
    private void endGame(String winner) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");

        if (winner.equals("Nobody")) {
            alert.setHeaderText("Game result : " + "DRAW");
        }
        else {
            alert.setHeaderText("Game result : " + "Winner : " + winner);
        }

        alert.showAndWait();
        startNewGame();
    }

    /** A method that return all buttons to started condition */
    public void startNewGame() {
        textOnButtons = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                textOnButtons[i][j] = "";
            }
        }

        numberOfPressedButtons = 0;
        textOnButton = "X";
        textField.setText("Now turn X");
    }

    private void nextTurn() {
        if ("X".equals(textOnButton)) {
            textOnButton = "0";
        }
        else {
            textOnButton = "X";
        }
    }

    private void changeText() {
        textField.setText("Now turn " + textOnButton);
    }

    public void initialize() {
        buttons = new Button[][] {{button1, button2, button3}, {button4, button5, button6}, {button7, button8, button9}};
        startNewGame();
    }

    @FXML
    private Label textField;

    @FXML
    private Button startNewGame;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;
}
