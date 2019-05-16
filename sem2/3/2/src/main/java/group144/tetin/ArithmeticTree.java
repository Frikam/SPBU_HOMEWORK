package group144.tetin;

import java.io.PrintStream;

import java.util.Scanner;

/** A class represent Arithmetic tree */
public class ArithmeticTree {
    private Node head;

    ArithmeticTree(Scanner scanner){
        head = new OperatorNode(scanner.next());
        readExpression(scanner, (OperatorNode) head);
    }

    /** A method that prints arithmetic tree */
    public void print(PrintStream stream) {
        head.print(stream);
    }

    /** A method that calculate result of arithmetic tree */
    public int calculate() {
        return head.calculate();
    }

    /** A method that create tree from expression */
    private Node readExpression(Scanner scanner, OperatorNode current) {
        if (scanner.hasNextInt()) {
            current.left = new OperandNode(scanner.next());
        } else {
            current.left = new OperatorNode(scanner.next());
            readExpression(scanner, (OperatorNode) current.left);
        }

        if (scanner.hasNext()) {
            String expression = scanner.next();
            if (isNumber(expression)) {
                current.right = new OperandNode(expression);
            }
            else {
                current.right = new OperatorNode(expression);
                readExpression(scanner, (OperatorNode) current.right);
            }
        }

        return current;
    }

    /** Checks if a string is a number */
    private boolean isNumber(String expression){
        int length = expression.length();
        char symbol;
        for (int i = 1; i < length; i++) {
            symbol = expression.charAt(i);
            if (!(Character.isDigit(symbol)) &&  symbol != ')') { // "1)"
                return false;
            }
        }
        symbol = expression.charAt(0);
        return symbol == '-' && length > 1 || Character.isDigit(symbol);
    }
}
