package group144.tetin;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            ArithmeticTree tree = new ArithmeticTree(in);
            System.out.println("Arithmetic tree:");
            tree.print(System.out);
            System.out.print("\n" + "Result: ");
            System.out.println(tree.calculate());
        } catch (FileNotFoundException fileException) {
            System.out.println("File is not found");
        }
    }
}