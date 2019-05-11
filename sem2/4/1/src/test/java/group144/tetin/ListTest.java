package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void add() throws AlreadyInListException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("3 2 1 ", list.printList());
    }

    @Test
    void addElementWithIndex() throws AlreadyInListException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(3);
        list.add(2, 1);
        assertEquals("3 2 1 ", list.printList());

    }

    @Test
    void remove() throws AlreadyInListException, EmptyListException, ElementNotFoundException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.remove(3);
        assertEquals("2 1 ", list.printList());
    }

    @Test
    void removeNonExistentElement() throws AlreadyInListException, EmptyListException, ElementNotFoundException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(3);
        list.add(2);
        assertThrows(ElementNotFoundException.class, () -> list.remove(5));
    }

    @Test
    void removeElementWithIndex() throws AlreadyInListException, EmptyListException, ElementNotFoundException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.remove(3);
        assertEquals("2 1 ", list.printList());
    }
}