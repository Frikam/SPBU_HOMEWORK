package group144.tetin;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void size() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        assertEquals(3, tree.size());
        tree.add(1);
        tree.add(4);
        assertEquals(4, tree.size());
        tree.delete(4);
        tree.delete(1);
        tree.delete(3);
        tree.delete(5);
        assertEquals(0, tree.size());
    }

    @Test
    public void isEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        tree.add(4);
        assertFalse(tree.isEmpty());
        tree.delete(4);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void add() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        assertFalse(tree.contains(6));
        tree.add(6);
        assertTrue(tree.contains(6));
    }

    @Test
    public void defaultTreeDelete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.delete(1);
    }

    @Test
    public void delete1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.add(10);
        tree.delete(1);
    }

    @Test
    public void delete2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.add(9);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.delete(7);
        assertEquals(5, tree.size());
        assertFalse(tree.delete(12));
    }

    @Test
    public void contains1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(6));
        assertFalse(tree.contains(12));
    }

    @Test
    public void contains2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertFalse(tree.contains(5));
    }

    @Test
    public void iterator() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("b0");
        tree.add("c1");
        tree.add("d2");
        tree.add("e3");

        Iterator<String> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("b0", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d2", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("e3", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorForEach() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        LinkedList<String> list = new LinkedList<>();
        tree.add("Jake");
        tree.add("Josh");
        tree.add("Mike");

        for (String element: tree) {
            list.add(element);
        }

        Iterator<String> iterator = tree.iterator();
        assertEquals("Jake", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Josh", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Mike", iterator.next());
        assertFalse(iterator.hasNext());
    }
}