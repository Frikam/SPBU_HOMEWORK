package group144.tetin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Contoller {
    /** Array that keep number buttons */
    private Button[] buttons;

    private Calculator calculator = new Calculator();

    private boolean previousSymbolIsNumber = true;

    private StringBuilder expression = new StringBuilder().append("0");

    @FXML
    private TextField textField;

    /** Action when press reset button */
    public void pressOnReset() {
        expression.delete(0, expression.length()).append("0");
        previousSymbolIsNumber = true;
        updateText();
    }

    /** Action when press number button */
    public void pressOnNumber(ActionEvent event) {
        if (expression.toString().equals("0") ||
                (expression.charAt(expression.length() - 2) == '-' &&
                        expression.charAt(expression.length() - 1) == '0')) {
            expression.deleteCharAt(expression.length() - 1);
        }
        for (int i = 0; i < 10; i++) {
            if (event.getSource().equals(buttons[i])) {
                expression.append(i);
            }
        }

        previousSymbolIsNumber = true;
        updateText();
    }

    /** Action when press operation button */
    public void pressOnOperation(ActionEvent event) {
        if (!previousSymbolIsNumber) {
            pressOnReset();
            textField.setText("WRONG EXPRESSION!!!");
            return;
        }

        calculate();
        if (event.getSource().equals(plus)) {
            expression.append(" +");
        } else if (event.getSource().equals(minus)) {
            expression.append(" -");
        } else if (event.getSource().equals(multiply)) {
            expression.append(" *");
        } else if (event.getSource().equals(div)) {
            expression.append(" /");
        }

        if (previousSymbolIsNumber) {
            expression.append(" ");
        }

        previousSymbolIsNumber = false;
        updateText();
    }

    /** Action whe press change sign button */
    public void pressOnChangeSign() {
        int indexOfChangedSign = 0;
        if (!previousSymbolIsNumber) {
            indexOfChangedSign = expression.length() - 1;
        }

        if (expression.charAt(indexOfChangedSign) == '-') {
            expression.deleteCharAt(indexOfChangedSign);
        } else {
            if (indexOfChangedSign == 0) {
                expression.replace(0, 0, "-");
            } else {
                expression.append("-");
            }
        }

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
            expression = calculator.calculateExpression(expression.toString());
            updateText();
            return true;
        } catch (ArithmeticException e) {
            textField.setText("ERROR DIVIDING BY 0!!!");
        } catch (WrongExpressionException e) {
            textField.setText("WRONG EXPRESSION!!!");
        }
        expression.delete(0, expression.length());
        return false;
    }

    /** A method that updates text field */
    private void updateText() {
        textField.setText(expression.toString());
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
