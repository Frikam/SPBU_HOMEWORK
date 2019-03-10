package group144.tetin;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    private void swap(int a, int b, int[] array) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
