package group144.tetin;

import java.io.PrintStream;

/** An interface that represent tree element that could be operand or operator and two child*/
public interface Node {
    /** A method that calculates value of the Node */
    int calculate();

    /** A method that prints Node */
    void print(PrintStream stream);
}
