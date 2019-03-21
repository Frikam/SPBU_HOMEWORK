package group144.tetin;

import java.io.PrintStream;

import java.util.Scanner;

public class ArithmeticTree {
    private Node head;

    ArithmeticTree(Scanner scanner){
        head = new OperatorNode(scanner, scanner.next());
    }

    public void print(PrintStream stream) {
        head.print(stream);
    }

    public int calculate() {
        return head.calculate();
    }


}
