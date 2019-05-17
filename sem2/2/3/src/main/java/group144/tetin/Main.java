package group144.tetin;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] abs) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("If you want print in file, enter \"F\", else enter \"C\".");
        System.out.print("Enter \"F\" or \"C\" : ");
        String typeOfOutput = in.nextLine();

        while (!typeOfOutput.equals("F") && !typeOfOutput.equals("C")) {
            System.out.print("Incorrect choice. Try again: ");
            typeOfOutput = in.nextLine();
        }

        int[][] matrix = inputMatrix(in);
        SpiralWriter writer;

        if (typeOfOutput.equals("C")) {
            writer = new OutputInConsole();
        }
        else {
            writer = new OutputInFile();
        }

        writer.printSpiral(matrix);
    }

    private static int[][] inputMatrix(Scanner in) {
        int number = 1;
        System.out.println("Array NxN, N should be a odd number");
        System.out.print("Enter N : ");
        int n = in.nextInt();

        while (n % 2 == 0) {
            System.out.println("N should be a odd number, try again");
            System.out.print("Enter N : ");
            n = in.nextInt();
        }

        int[][] matrix = new int [n][n];

        System.out.println("Array : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = number;
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }

        System.out.println();
        return matrix;
    }
}
