package group144.tetin;

public class OutputInConsole extends SpriralOutputter {
    @Override
    public String printSpiral(int[][] matrix) {
        String result = getPrintSpiral(matrix);
        System.out.print(result);
        return result;
    }
}
