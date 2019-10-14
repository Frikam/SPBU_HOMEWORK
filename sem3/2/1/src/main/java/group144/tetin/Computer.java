package group144.tetin;

import java.util.LinkedList;

public class Computer {
    private OS os;
    private boolean isInfected = false;
    private LinkedList<Computer> connectedComputers = new LinkedList<>();
    private int numberOfInfectionAttempts = 0;

    Computer(OS os) {
        this.os = os;
    }

    public OS getOS() {
        return os;
    }

    public void connectComputer(Computer computer) {
        connectedComputers.add(computer);
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void infectComputer() {
        if (numberOfInfectionAttempts == 0) {
            numberOfInfectionAttempts++;
        }
        isInfected = true;
        tryInfectConnectedComputers();
    }

    public int getNumberOfAttempts() {
        return numberOfInfectionAttempts;
    }

    private void tryInfectConnectedComputers() {
        for (Computer computer: connectedComputers) {
            if (!computer.isInfected() && computer.tryInfect()) {
                computer.infectComputer();
            }
        }
    }

    private boolean willBeInfected(Computer computer) {

        OS computerOS = computer.getOS();
        return computerOS.willBeInfected();
    }

    private boolean tryInfect() {
        numberOfInfectionAttempts++;
        return os.willBeInfected();
    }
}
