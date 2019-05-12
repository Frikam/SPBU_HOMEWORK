package group144.tetin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** A class that represent parallel quick sort */
public class ParallelQuickSort implements QuickSorter {
    @Override
    public void sort(Integer[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new RecursiveQSort(array, 0, array.length - 1));
    }

    private class RecursiveQSort extends RecursiveAction {
        private Integer[] array;
        private int startIndex;
        private int endIndex;

        private RecursiveQSort(Integer[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected void compute() {
            if (startIndex >= endIndex) {
                return;
            }

            int leftIndex = startIndex;
            int rightIndex = endIndex;
            int current = leftIndex - (leftIndex - rightIndex) / 2;

            while (leftIndex < rightIndex) {
                while (leftIndex < current && (array[leftIndex] <= array[current])) {
                    leftIndex++;
                }

                while (rightIndex > current && (array[current] <= array[rightIndex])) {
                    rightIndex--;
                }

                if (leftIndex < rightIndex) {
                    int temp = array[leftIndex];
                    array[leftIndex] = array[rightIndex];
                    array[rightIndex] = temp;

                    if (leftIndex == current) {
                        current = rightIndex;
                    }
                    else if (rightIndex == current) {
                        current = leftIndex;
                    }
                }
            }

            RecursiveQSort leftPart = new RecursiveQSort(array, startIndex, current);
            RecursiveQSort rightPart = new RecursiveQSort(array, current + 1, endIndex);

            rightPart.fork();
            leftPart.compute();
            rightPart.join();
        }
    }
}
