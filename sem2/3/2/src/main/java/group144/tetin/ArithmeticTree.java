package group144.tetin;

import java.io.PrintStream;

import java.util.Scanner;

/** A class represent Arithmetic tree */
public class ArithmeticTree {
    private Node head;

    ArithmeticTree(Scanner scanner){
        head = new OperatorNode(scanner, scanner.next());
    }

    /** A method that prints arithmetic tree */
    public void print(PrintStream stream) {
        head.print(stream);
    }

    /** A method that calculate result of arithmetic tree */
    public int calculate() {
        return head.calculate();
    }


}
