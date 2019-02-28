package group144.tetin;

import java.util.Random;

public class BogoSorter implements Sorter {
    @Override
    public void sort(int[] array){
        if (array.length == 0){
            return;
        }
        while(!isSorted(array))
        {
             refreshArray(array);
        }
    }

    private void refreshArray(int[] array){
        Random random = new Random();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            swap(i, j, array);
        }
    }

    private boolean isSorted(int[] array){
        int length = array.length;
        for (int i = 0; i < length - 1; i++){
            if (array[i] > array[i + 1]){
                return false;
            }
        }

        return true;
    }

    private void swap(int a, int b, int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
