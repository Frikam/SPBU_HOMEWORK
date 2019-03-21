package group144.tetin;

import java.io.PrintStream;
import java.util.Scanner;

public class OperatorNode implements Node {
    private char operation;
    private Node left;
    private Node right;

    OperatorNode(Scanner scanner, String expression) {
        operation = expression.charAt(expression.length() - 1); // "(+"

        if (scanner.hasNextInt()) {
            left = new OperandNode(scanner.next());
        } else {
            left = new OperatorNode(scanner, scanner.next());
        }

        if (scanner.hasNext()) { // "1)"
            expression = scanner.next();
            if (isNumber(expression)) {
                right = new OperandNode(expression);
            }
            else {
                right = new OperatorNode(scanner, expression);
            }
        }
    }

    /** Checks if a string is a number */
    private boolean isNumber(String expression){
        int length = expression.length();
        char symbol;
        for (int i = 1; i < length; i++) {
            symbol = expression.charAt(i);
            if (!(Character.isDigit(symbol)) &&  symbol != ')') {
                return false;
            }
        }
        symbol = expression.charAt(0);
        return symbol == '-' && length > 1 || Character.isDigit(symbol);
    }

    @Override
    public int calculate() {
        switch (operation) {
            case '+':
                return left.calculate() + right.calculate();
            case '-':
                return left.calculate() - right.calculate();
            case '*':
                return left.calculate() * right.calculate();
            case '/':
                return left.calculate() / right.calculate();
            default:
                return 0;
        }
    }

    @Override
    public void print(PrintStream stream) {
        stream.print('(');
        stream.print(operation);
        stream.print(' ');
        left.print(stream);
        stream.print(' ');
        right.print(stream);
        stream.print(')');
    }
}