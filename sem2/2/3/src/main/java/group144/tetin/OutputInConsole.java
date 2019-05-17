package group144.tetin;

import java.io.PrintStream;

/** Class represent spiral writer output to the console */
public class OutputInConsole extends SpriralOutputter implements SpiralWriter {
    @Override
    public void printSpiral(int[][] matrix) {
        spiralPrinter(matrix, new PrintStream(System.out));
    }
}
