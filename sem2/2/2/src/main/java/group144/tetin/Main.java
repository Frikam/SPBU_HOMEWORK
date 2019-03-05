package group144.tetin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program calculate your expression");
        System.out.print("Enter expression in postfix form : ");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        Calculator calculator = new Calculator();
        System.out.println("Answer : " + calculator.calculate(string));
    }
}
