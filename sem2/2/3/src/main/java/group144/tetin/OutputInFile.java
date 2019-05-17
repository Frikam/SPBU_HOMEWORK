package group144.tetin;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/** Class represent spiral writer output to the file */
public class OutputInFile extends SpriralOutputter implements SpiralWriter {
    @Override
    public void printSpiral(int[][] matrix) throws FileNotFoundException {
        getPrintSpiral(matrix, new PrintStream("output.txt"));
    }
}
