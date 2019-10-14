package group144.tetin;

import java.util.Random;

public class OS {
    private String name;
    private double chanceOfInfection;
    private Random generatorOfChance = new Random();

    OS(String name, Double chanceOfInfection) {
        this.name = name;
        this.chanceOfInfection = chanceOfInfection;
    }

    OS(String name, Double chanceOfInfection, Random generatorOfChance) {
        this.name = name;
        this.chanceOfInfection = chanceOfInfection;
        this.generatorOfChance = generatorOfChance;
    }

    public String getName() {
        return name;
    }

    public boolean willBeInfected() {
        return generatorOfChance.nextDouble() < chanceOfInfection;
    }
}
