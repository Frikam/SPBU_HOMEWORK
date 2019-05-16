package group144.tetin;

import java.io.PrintStream;
import java.util.Scanner;

/** A class that represent operator from Arithmetic tree */
public class OperatorNode implements Node {
    private char operation;
    public Node left;
    public Node right;

    OperatorNode(String expression) {
        operation = expression.charAt(expression.length() - 1); // "(+"
    }

    /** A method that calculate expression Node */
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

    /** A method that calculate result of arithmetic tree */
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