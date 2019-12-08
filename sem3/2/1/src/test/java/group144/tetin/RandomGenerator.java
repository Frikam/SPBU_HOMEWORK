package group144.tetin;

import java.util.List;
import java.util.Random;

public class RandomGenerator extends Random {
    private List<Double> values;
    private int size;
    private int counter = 0;

    RandomGenerator(List<Double> values) {
        this.values = values;
        size = values.size();
    }
    @Override
    public double nextDouble() {
        return values.get((counter++) % size);
    }
}
