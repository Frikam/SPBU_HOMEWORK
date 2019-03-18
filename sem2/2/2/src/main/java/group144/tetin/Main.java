package group144.tetin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyStackException {
        System.out.println("Program calculate your expression");
        System.out.print("Enter expression in postfix form : ");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        Calculator calculator = new Calculator();
        try {
            System.out.println("Answer : " + calculator.calculate(string));
        } catch (EmptyStackException e) {
            System.out.println("Wrong expression");
            throw e;
        }
    }
}
