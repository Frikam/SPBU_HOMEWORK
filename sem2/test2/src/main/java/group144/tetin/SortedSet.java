package group144.tetin;

import java.util.LinkedList;

public class SortedSet implements ListsComparator {
    /** List that saves list in descending order of the size list */
    private LinkedList<LinkedList<String>> list = new LinkedList<>();

    /** A method that adds list in set based on sie of list */
    public void add(LinkedList<String> addedList) {
        if (list.isEmpty()) {
            list.add(addedList);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (compare(addedList ,list.get(i)) >= 0) {
                list.add(i, addedList);
                return;
            }
        }

        list.addLast(addedList);
    }

    /** A method that compare two list by number of elements in list */
    @Override
    public int compare(LinkedList<String> firstList, LinkedList<String> secondList) {
        if (firstList.size() > secondList.size()) {
            return 1;
        }

        if (firstList.size() < secondList.size()) {
            return -1;
        }

        return 0;
    }

    /** A method that print set */
    public void print() {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
