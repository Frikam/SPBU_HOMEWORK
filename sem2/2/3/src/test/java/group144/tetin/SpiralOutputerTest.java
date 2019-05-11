package group144.tetin;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SpiralOutputerTest {
    @Test
    public void printSpiral3() {
        SpiralWriter writer = new OutputInConsole();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        writer.printSpiral(array);
        String EXPECTED = "5 4 7 8 9 6 3 2 1 \n";
        assertEquals(EXPECTED, arrayOutputStream.toString());
    }

    @Test
    public void printSpiral1() {
        SpiralWriter writer = new OutputInConsole();
        int[][] array = {{1}};
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        writer.printSpiral(array);
        String EXPECTED = "1 \n";
        assertEquals(EXPECTED, arrayOutputStream.toString());
    }
}