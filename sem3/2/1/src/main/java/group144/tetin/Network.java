package group144.tetin;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Network {
    private LinkedList<Computer> computers = new LinkedList<>();
    private String[][] connections;

    Network(String fileName, Computer... computers) throws IOException {
        Collections.addAll(this.computers, computers);

        connections = getConnections(fileName);
        connectComputers();
    }

    private void connectComputers() {
        int length = connections.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (connections[i][j].equals("1")) {
                    connections[j][i] = "0";
                    connectComputers(computers.get(i), computers.get(j));
                }
            }
        }
    }

    private void connectComputers(Computer firstComputer, Computer secondComputer) {
        firstComputer.connectComputer(secondComputer);
        secondComputer.connectComputer(firstComputer);
    }

    public void infectComputer(Computer computer) {
        computer.infectComputer();
    }

    public String getNetworkStatus() {
        StringBuilder networkStatus = new StringBuilder();
        for (Computer computer: computers) {
            networkStatus.append("Computer with ");
            networkStatus.append(computer.getOS().getName());
            networkStatus.append(" OS is infected: ");
            networkStatus.append(computer.isInfected());
            networkStatus.append("\n");
        }

        return networkStatus.toString();
    }

    public LinkedList<Computer> getInfectedComputers() {
        LinkedList<Computer> infectedComputers = new LinkedList<>();
        for (Computer computer: computers) {
            if (computer.isInfected()) {
                infectedComputers.add(computer);
            }
        }

        return infectedComputers;
    }

    public LinkedList<Computer> getUninfectedComputers() {
        LinkedList<Computer> uninfectedComputers = new LinkedList<>();
        for (Computer computer: computers) {
            if (!computer.isInfected()) {
                uninfectedComputers.add(computer);
            }
        }

        return uninfectedComputers;
    }

    private String[][] getConnections(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        Scanner in = new Scanner(fileReader);
        String[] line = in.nextLine().split(" ");
        int length = line.length;
        int i = 0;
        String[][] connection = new String[length][length];
        connection[i] = line;
        do {
            i++;
            line = in.nextLine().split(" ");
            connection[i] = line;
        } while (in.hasNextLine());

        return connection;
    }
}
