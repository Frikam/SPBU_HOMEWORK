package group144.tetin;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ComputerTest {
    @Test
    public void infectComputerTest() {
        OS mac = new OS("mac", 0.40);
        Computer macComputer = new Computer(mac);

        assertFalse(macComputer.isInfected());
        macComputer.infectComputer();
        assertTrue(macComputer.isInfected());

    }

    @Test
    public void infectConnectedComputersTest() {
        OS windows = new OS("windows", 1.0);
        OS mac = new OS("mac", 0.5);
        OS linux = new OS("linux", 0.0);
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);

        macComputer.connectComputer(windowsComputer);
        macComputer.connectComputer(linuxComputer);
        linuxComputer.connectComputer(macComputer);
        windowsComputer.connectComputer(macComputer);

        macComputer.infectComputer();

        assertTrue(windowsComputer.isInfected());
        assertFalse(linuxComputer.isInfected());
    }

    @Test
    public void numberOfInfectionAttemptsTest() {
        OS windows = new OS("windows", 1.0);
        OS mac = new OS("mac", 0.5);
        OS linux = new OS("linux", 0.0);
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);

        macComputer.connectComputer(windowsComputer);
        macComputer.connectComputer(linuxComputer);
        linuxComputer.connectComputer(macComputer);
        windowsComputer.connectComputer(macComputer);
        windowsComputer.connectComputer(linuxComputer);

        macComputer.infectComputer();

        assertEquals(1, windowsComputer.getNumberOfAttempts());
        assertEquals(1, macComputer.getNumberOfAttempts());
        assertEquals(2, linuxComputer.getNumberOfAttempts());

    }
}