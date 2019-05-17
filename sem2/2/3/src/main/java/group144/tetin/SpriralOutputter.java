package group144.tetin;

import java.io.PrintStream;

/** Class represents spiral writer as string */
public class SpriralOutputter {
    public void getPrintSpiral(int[][] matrix, PrintStream stream) {
        int num = matrix.length;
        int step = 0;
        int index1 = num / 2;
        int index2 = num / 2;
        stream.print(matrix[index1][index2] + " ");

        while (index1 != 0 || index2 != num - 1) {
            step++;
            for (int j = 0; j < step; j++) {
                index2--;
                stream.print(matrix[index1][index2] + " ");
            }

            for (int j = 0; j < step; j++) {
                index1++;
                stream.print(matrix[index1][index2] + " ");
            }

            step++;
            for (int j = 0; j < step; j++) {
                index2++;
                stream.print(matrix[index1][index2] + " ");
            }

            for (int j = 0; j < step; j++) {
                index1--;
                stream.print(matrix[index1][index2] + " ");
            }
        }

        for (int j = 0; j < step; j++) {
            index2--;
            stream.print(matrix[index1][index2] + " ");
        }
    }

}
