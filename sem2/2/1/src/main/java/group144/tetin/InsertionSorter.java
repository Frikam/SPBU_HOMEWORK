package group144.tetin;


/** Class presents Insertion sort */
public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        if (length == 0) {
            return;
        }
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j != 0 && array[j] < array[j - 1]){
                swap(j, j - 1, array);
                j--;
            }
        }
    }


    private void swap(int a, int b, int[] array) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
