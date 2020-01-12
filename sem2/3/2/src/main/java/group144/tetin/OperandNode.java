package group144.tetin;

import java.io.PrintStream;

/** A class that represent operand from Arithmetic tree */
public class OperandNode implements Node {
    private int value;

    OperandNode(String input) {
        if (input.charAt(input.length() - 1) == ')') {
            value = Integer.parseInt(input.substring(0, input.indexOf(')')));
        } else {
            value = Integer.parseInt(input);
        }
    }

    /** A method that return Node number  */
    @Override
    public int calculate() {
        return value;
    }

    /** A method that prints Node number  */
    @Override
    public void print(PrintStream stream) {
        stream.print(value);
    }
}