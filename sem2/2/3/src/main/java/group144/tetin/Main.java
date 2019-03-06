package group144.tetin;

import java.util.Scanner;

public class Main {
    public static void main(String[] abs) {
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
        System.out.println("Array NxN, N should be a prime number");
        System.out.print("Enter N : ");
        int n = in.nextInt();
        int[][] matrix = new int [n][n];

        while (n % 2 == 0) {
            System.out.println("N should be a prime number, try again");
            System.out.print("Enter N : ");
            n = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
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