package group144.tetin;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OSTest {
    @Test
    public void getNameTest() {
        OS linux = new OS("linux", 0.5);

        assertEquals("linux", linux.getName());
    }

    @Test
    public void willBeInfectedTest() {
        OS linux = new OS("linux", 0.5, new RandomGenerator(Arrays.asList(0.3, 0.2)));
        assertTrue(linux.willBeInfected());
    }
}