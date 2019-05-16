package group144.tetin;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SortedSetTest {
    @Test
    public void addTest1() {
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
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        set.print();
        assertEquals("a b c d \n" +
                "a b c \n", arrayOutputStream.toString());
    }

    @Test
    public void addTest2() {
        SortedSet set = new SortedSet();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("a");
        firstList.add("b");
        firstList.add("c");
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("a");
        secondList.add("b");
        secondList.add("c");
        secondList.add("d");
        set.add(firstList);
        set.add(secondList);
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        set.print();
        assertEquals("a b c d \n" +
                "a b c \n", arrayOutputStream.toString());
    }
}