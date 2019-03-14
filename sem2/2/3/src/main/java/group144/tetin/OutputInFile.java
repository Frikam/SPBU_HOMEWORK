package group144.tetin;

import java.io.FileWriter;

import java.io.IOException;

/** Class represent spiral writer output to the file */
public class OutputInFile extends SpriralOutputter implements SpiralWriter{
    @Override
    public String printSpiral(int[][] matrix) {
        String result = getPrintSpiral(matrix);
        FileWriter writer;

        try {
            writer = new FileWriter("output.txt");
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return result;
    }
}
