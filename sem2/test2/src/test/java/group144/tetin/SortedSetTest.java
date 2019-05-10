package group144.tetin;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class SortedSetTest {
    @Test
    public void addTest() {
        SortedSet set = new SortedSet();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("a");
        firstList.add("b");
        firstList.add("c");
        firstList.add("d");
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("a");
        secondList.add("b");
        secondList.add("c");
        set.add(firstList);
        set.add(secondList);
        set.print();
    }

    publci
}