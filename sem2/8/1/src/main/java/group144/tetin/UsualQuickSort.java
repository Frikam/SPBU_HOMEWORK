package group144.tetin;

public class UsualQuickSort implements QuickSorter {
    private Integer[] array;
    private int startIndex;
    private int endIndex;

    public void sort(Integer[] array) {
        this.array = array;
        startIndex = 0;
        endIndex = array.length - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int startIndex, int endIndex) {
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
        doSort(startIndex, current);
        doSort(current + 1, endIndex);
    }
}
