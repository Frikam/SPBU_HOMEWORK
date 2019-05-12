package group144.tetin;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
    private static final int SIZE_OF_ARRAY = 1000000;
    private static final int NUMBER_OF_TESTS = 10;

    public static void main(String[] abs) {
        QuickSorter usualSorter = new UsualQuickSort();
        QuickSorter parallelSorter = new ParallelQuickSort();
        long usualSorterTime = 0;
        long parallelSorterTime = 0;
        
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Integer[] usualSortArray = initializeArray();
            Integer[] parallelSortArray = usualSortArray.clone();

            usualSorterTime += calculateTime(usualSorter ,usualSortArray);
            parallelSorterTime += calculateTime(parallelSorter, parallelSortArray);
        }

        long averageUsualSortTime = usualSorterTime / NUMBER_OF_TESTS;
        long averageParallelSortTime = parallelSorterTime / NUMBER_OF_TESTS;

        System.out.println("Average usual quick sorter time : " + averageUsualSortTime + " ns");
        System.out.println("Average usual parallel sorter time : " + averageParallelSortTime + " ns");
    }

    private static long calculateTime(QuickSorter sorter, Integer[] array) {
        long startTime = System.nanoTime();
        sorter.sort(array);
        return System.nanoTime() - startTime;
    }

    private static Integer[] initializeArray() {
        Random random = new Random();
        return Stream.generate(() -> (random.nextInt() % 500)).limit(SIZE_OF_ARRAY).toArray(Integer[]::new);
    }
}
