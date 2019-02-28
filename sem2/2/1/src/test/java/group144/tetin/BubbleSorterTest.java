package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {
    @Test
    public void sortReversed(){
        int[] array = {5, 4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4, 5};
        Sorter sorter = new BubbleSorter();
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void sortSorted(){
        int[] array = {1, 2, 3, 4, 5};
        int[] sortedArray = {1, 2, 3, 4, 5};
        Sorter sorter = new BubbleSorter();
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void sortRandomly(){
        int[] array = {4, 5, 3, 1, 2};
        int[] sortedArray = {1, 2, 3, 4, 5};
        Sorter sorter = new BubbleSorter();
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }


    @Test
    public void sortEmpty(){
        int[] array = {};
        int[] sortedArray = {};
        Sorter sorter = new BubbleSorter();
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}