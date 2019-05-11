package group144.tetin;

/** Class represent spiral writer output to the console */
public class OutputInConsole extends SpriralOutputter implements SpiralWriter {
    @Override
    public void printSpiral(int[][] matrix) {
        String result = getPrintSpiral(matrix);
        System.out.println(result);
    }
}
