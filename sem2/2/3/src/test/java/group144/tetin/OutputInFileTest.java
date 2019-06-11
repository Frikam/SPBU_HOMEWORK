package group144.tetin;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class OutputInFileTest {
    @Test
    public void printSpiral3() throws FileNotFoundException {
        SpiralWriter writer = new OutputInFile();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        writer.printSpiral(array);
        Scanner file = new Scanner(new File("output.txt"));
        file.useDelimiter("\n");
        String EXPECTED = "5 4 7 8 9 6 3 2 1 ";
        assertEquals(EXPECTED, file.next());
        file.close();
    }

    @Test
    public void printSpiral1() throws FileNotFoundException {
        SpiralWriter writer = new OutputInFile();
        int[][] array = {{1}};
        writer.printSpiral(array);
        Scanner file = new Scanner(new File("output.txt"));
        file.useDelimiter("\n");
        String EXPECTED = "1 ";
        assertEquals(EXPECTED, file.next());
        file.close();
    }
}