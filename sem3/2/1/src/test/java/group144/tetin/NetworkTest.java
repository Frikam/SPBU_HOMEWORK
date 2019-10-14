package group144.tetin;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

public class NetworkTest {
    @Test
    public void networkTest() throws IOException {
        OS linux = new OS("linux", 0.40, new RandomGenerator(Arrays.asList(0.2, 0.5, 0.7)));
        OS mac = new OS("mac", 0.40, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS windows = new OS("windows", 0.50, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS chrome = new OS("chrome", 0.30, new RandomGenerator(Arrays.asList(0.5, 0.2, 0.7)));
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);
        Computer chromeComputer  = new Computer(chrome);
        Network network = new Network( "connection.txt", macComputer,windowsComputer,linuxComputer,chromeComputer);

        network.infectComputer(macComputer);

        assertTrue(macComputer.isInfected());
        assertFalse(windowsComputer.isInfected());
        assertTrue(linuxComputer.isInfected());
        assertTrue(chromeComputer.isInfected());

        assertEquals(1, macComputer.getNumberOfAttempts());
        assertEquals(0, windowsComputer.getNumberOfAttempts());
        assertEquals(1, linuxComputer.getNumberOfAttempts());
        assertEquals(2, chromeComputer.getNumberOfAttempts());
    }

    @Test
    public void getNetworkStatusTest() throws IOException {
        OS linux = new OS("linux", 0.40, new RandomGenerator(Arrays.asList(0.2, 0.5, 0.7)));
        OS mac = new OS("mac", 0.40, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS windows = new OS("windows", 0.50, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS chrome = new OS("chrome", 0.30, new RandomGenerator(Arrays.asList(0.5, 0.2, 0.7)));
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);
        Computer chromeComputer  = new Computer(chrome);
        Network network = new Network( "connection.txt", macComputer,windowsComputer,linuxComputer,chromeComputer);

        network.infectComputer(macComputer);
        String networkStatus = "Computer with mac OS is infected: true\n" +
                "Computer with windows OS is infected: false\n" +
                "Computer with linux OS is infected: true\n" +
                "Computer with chrome OS is infected: true\n";
        assertEquals(networkStatus, network.getNetworkStatus());
    }

    @Test
    public void getInfectedComputersTest() throws IOException {
        OS linux = new OS("linux", 0.40, new RandomGenerator(Arrays.asList(0.2, 0.5, 0.7)));
        OS mac = new OS("mac", 0.40, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS windows = new OS("windows", 0.50, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS chrome = new OS("chrome", 0.30, new RandomGenerator(Arrays.asList(0.5, 0.2, 0.7)));
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);
        Computer chromeComputer  = new Computer(chrome);
        Network network = new Network( "connection.txt", macComputer,windowsComputer,linuxComputer,chromeComputer);
        network.infectComputer(macComputer);
        List<Computer> infectedComputers = Arrays.asList(macComputer, linuxComputer, chromeComputer);
        assertEquals(infectedComputers, network.getInfectedComputers());
    }

    @Test
    public void getUninfectedComputersTest() throws IOException {
        OS linux = new OS("linux", 0.40, new RandomGenerator(Arrays.asList(0.2, 0.5, 0.7)));
        OS mac = new OS("mac", 0.40, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS windows = new OS("windows", 0.50, new RandomGenerator(Arrays.asList(0.3, 0.5, 0.7)));
        OS chrome = new OS("chrome", 0.30, new RandomGenerator(Arrays.asList(0.5, 0.2, 0.7)));
        Computer macComputer = new Computer(mac);
        Computer windowsComputer = new Computer(windows);
        Computer linuxComputer = new Computer(linux);
        Computer chromeComputer  = new Computer(chrome);
        Network network = new Network( "connection.txt", macComputer,windowsComputer,linuxComputer,chromeComputer);

        network.infectComputer(macComputer);

        List<Computer> uninfectedComputers = Arrays.asList(windowsComputer);
        assertEquals(uninfectedComputers, network.getUninfectedComputers());
    }
}