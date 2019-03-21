package group144.tetin;

import java.io.PrintStream;

public class OperandNode implements Node {
    private int value;

    OperandNode(String input) {
        if (input.charAt(input.length() - 1) == ')') {
            value = Integer.parseInt(input.substring(0, input.indexOf(')')));
        } else {
            value = Integer.parseInt(input);
        }
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public void print(PrintStream stream) {
        stream.print(value);
    }
}