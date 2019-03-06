package group144.tetin;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralOutputerTest {
    @Test
    public void printSpiral3() {
        SpiralWriter writer = new OutputInConsole();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String answer = writer.printSpiral(array);
        String EXPECTED = "5 4 7 8 9 6 3 2 1 ";
        assertEquals(EXPECTED, answer);
    }

    @Test
    public void printSpiral1() {
        SpiralWriter writer = new OutputInConsole();
        int[][] array = {{1}};
        String answer = writer.printSpiral(array);
        String EXPECTED = "1 ";
        assertEquals(EXPECTED, answer);
    }

}