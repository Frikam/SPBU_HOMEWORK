package group144.tetin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class AvlTreeTest {

    @Test
    public void balanceTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(3);
        assertEquals("(2 (1 null null) (3 null null))", avlTree.toString());
        for (int i = 4; i < 16; i++) {
            avlTree.add(i);
        }
        String EXPECTED = "(8 (4 (2 (1 null null) (3 null null)) (6 (5 null null) (7 null null)))" +
                " (12 (10 (9 null null) (11 null null)) (14 (13 null null) (15 null null))))";
        assertEquals(EXPECTED, avlTree.toString());
        for (int i = 1; i <= 10; i++) {
            avlTree.remove(i);
        }
        assertEquals("(12 (11 null null) (14 (13 null null) (15 null null)))", avlTree.toString());
        avlTree.remove(11);
        avlTree.remove(12);
        assertEquals("(14 (13 null null) (15 null null))", avlTree.toString());
    }

    @Test
    public void isEmptyTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        assertTrue(avlTree.isEmpty());
        avlTree.add(1);
        assertFalse(avlTree.isEmpty());
        avlTree.remove(1);
        assertTrue(avlTree.isEmpty());
    }

    @Test
    public void sizeTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        assertEquals(0, avlTree.size());
        avlTree.add("A");
        avlTree.add("B");
        assertEquals(2, avlTree.size());
        avlTree.remove("A");
        assertEquals(1, avlTree.size());
        avlTree.remove("B");
        assertEquals(0, avlTree.size());
    }

    @Test
    public void containsTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        assertFalse(avlTree.contains("1"));
        avlTree.add("1");
        assertTrue(avlTree.contains("1"));
        avlTree.remove("1");
        assertFalse(avlTree.contains("1"));
    }

    @Test
    public void containsAllTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        Collection<String> collection = new ArrayList<>();
        avlTree.add("1");
        avlTree.add("2");
        avlTree.add("3");
        avlTree.add("4");
        collection.add("3");
        collection.add("2");
        collection.add("1");
        assertTrue(avlTree.containsAll(collection));
        collection.add("5");
        assertFalse(avlTree.containsAll(collection));
    }

    @Test
    public void removeAllTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        Collection<String> collection = new ArrayList<>();
        avlTree.add("1");
        avlTree.add("2");
        avlTree.add("3");
        avlTree.add("4");
        collection.add("1");
        collection.add("2");
        collection.add("3");
        assertTrue(avlTree.removeAll(collection));
        assertEquals("(4 null null)", avlTree.toString());
    }

    @Test
    public void retainAll() {
        AvlTree<String> avlTree = new AvlTree<>();
        Collection<String> collection = new ArrayList<>();
        avlTree.add("1");
        avlTree.add("2");
        avlTree.add("3");
        avlTree.add("4");
        collection.add("1");
        collection.add("2");
        collection.add("3");
        assertTrue(avlTree.retainAll(collection));
        assertEquals("(2 (1 null null) (3 null null))", avlTree.toString());
    }

    @Test
    public void toArrayTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(1);
        avlTree.add(5);
        avlTree.add(3);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 5}, avlTree.toArray());
    }

    @Test
    public void toArray1Test() {
        AvlTree<String> avlTree = new AvlTree<>();
        avlTree.add("a");
        avlTree.add("d");
        avlTree.add("a");
        avlTree.add("b");
        avlTree.add("a");
        assertArrayEquals(new String[]{"a", "a", "a", "b", "d"}, avlTree.toArray(new String[5]));
    }

    @Test
    public void addAllTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        avlTree.addAll(collection);
        assertTrue(avlTree.containsAll(collection));
        assertEquals(collection.size(), avlTree.size());
    }

    @Test
    public void clearTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        avlTree.add("1");
        avlTree.add("2");
        avlTree.add("3");
        assertFalse(avlTree.isEmpty());
        avlTree.clear();
        assertTrue(avlTree.isEmpty());
    }

    @Test
    public void iteratorTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        avlTree.add("1");
        avlTree.add("2");
        avlTree.add("3");
        Iterator<String> avlTreeIterator = avlTree.iterator();
        assertTrue(avlTreeIterator.hasNext());
        assertEquals("1", avlTreeIterator.next());
        assertEquals("2", avlTreeIterator.next());
        assertTrue(avlTreeIterator.hasNext());
        assertEquals("3", avlTreeIterator.next());
        assertFalse(avlTreeIterator.hasNext());
    }

    @Test
    public void removeTest() {
        AvlTree<String> avlTree = new AvlTree<>();
        assertFalse(avlTree.remove("1"));
        avlTree.add("1");
        avlTree.add("2");
        assertTrue(avlTree.remove("1"));
        assertFalse(avlTree.contains("1"));
        avlTree.remove("2");
        assertFalse(avlTree.contains("2"));
        assertTrue(avlTree.isEmpty());
    }
}