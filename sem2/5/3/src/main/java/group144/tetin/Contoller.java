package group144.tetin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Contoller {
    /** Array that keep number buttons */
    private Button[] buttons;

    private Calculator calculator = new Calculator();

    private boolean previousSymbolIsNumber = false;

    private String expression = "";

    private int numberOfOperation = 0; // number of operation pressed one after another

    @FXML
    private TextField textField;

    /** Action when press reset button */
    public void pressOnReset() {
        expression = "";
        previousSymbolIsNumber = false;
        updateText();
    }

    /** Action when press number button */
    public void pressOnNumber(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            if (event.getSource().equals(buttons[i])) {
                expression += "" + i;
            }
        }

        previousSymbolIsNumber = true;
        updateText();
    }

    /** Action when press operation button */
    public void pressOnOperation(ActionEvent event) {
        if (previousSymbolIsNumber) {
            numberOfOperation = 1;
            expression += " ";
        }
        else {
            numberOfOperation++;
        }

        boolean isMinus = event.getSource().equals(minus);

        if (!isMinus && numberOfOperation < 3) {
            if (!calculate()) {
                numberOfOperation = 0;
                return;
            }
        }



        if (event.getSource().equals(plus)) {
            expression += "+";
        } else if (event.getSource().equals(minus)) {
            expression += "-";
        } else if (event.getSource().equals(multiply)) {
            expression += "*";
        } else if (event.getSource().equals(div)) {
            expression += "/";
        }

        if (previousSymbolIsNumber) {
            expression += " ";
        }

        previousSymbolIsNumber = false;
        updateText();
    }

    /** Action when press equal button */
    public void pressOnEqual() {
        calculate();
    }

    /** A method that calculate answer
     * @return true - if expression entered right, else return false
     * */
    private boolean calculate() {
        try {
            expression = calculator.calculateExpression(expression);
            updateText();
            return true;
        } catch (ArithmeticException e) {
            textField.setText("ERROR DIVIDING BY 0!!!");
        } catch (WrongExpressionException e) {
            textField.setText("WRONG EXPRESSION!!!");
        }
        expression = "";
        return false;
    }

    /** A method that updates text field */
    private void updateText() {
        textField.setText(expression);
    }

    /** Initialization function */
    public void initialize() {
        buttons = new Button[]{button0, button1, button2, button3, button4, button5, button6, button7, button8, button9};
    }

    @FXML
    private Button button0;

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

    @FXML
    private Button multiply;

    @FXML
    private Button div;

    @FXML
    private Button plus;

    @FXML
    private Button minus;
}
