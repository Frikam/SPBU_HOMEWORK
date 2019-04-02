package group144.tetin;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Spinner<Integer> firstNumber;

    @FXML
    private Spinner<Integer> secondNumber;

    @FXML
    private TextField text;

    @FXML
    private ChoiceBox<Character> operation;

    /** A method that initializes spinners (numbers), choice box (operation) and text field (answer) */
    public void initialize() {
        firstNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-10, 10, 0));
        secondNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-10, 10, 0));

        firstNumber.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        secondNumber.valueProperty().addListener((observable, oldValue, newValue) -> calculate());

        operation.setItems(FXCollections.observableArrayList('+', '-', '*', '/', '%'));
        operation.valueProperty().setValue('+');

        operation.valueProperty().addListener((observable, oldValue, newValue) -> calculate());

        text.setText("0");

    }

    /** A method that calculate expression */
    private void calculate() {
        switch (operation.getValue()) {
            case '+' :
                text.setText("" + (firstNumber.getValue() + secondNumber.getValue()));
                break;
            case '-' :
                text.setText("" + (firstNumber.getValue() - secondNumber.getValue()));
                break;
            case '/' :
                if (secondNumber.getValue() == 0) {
                    text.setText("ERROR");
                    break;
                }
                text.setText("" + (firstNumber.getValue() / secondNumber.getValue()));
                break;
            case '*' :
                text.setText("" + (firstNumber.getValue() * secondNumber.getValue()));
                break;
            case '%' :
                text.setText("" + (firstNumber.getValue() % secondNumber.getValue()));
                break;
        }
    }
}
