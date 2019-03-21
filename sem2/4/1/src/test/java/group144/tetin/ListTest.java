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
    void addElementWithIndex() throws AlreadyInListException, WrongIndexException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2, 1);
        assertEquals("1 2 ", list.printList());

    }

    @Test
    void remove() {
    }

    @Test
    void remove1() {
    }

    @Test
    void elementInList() {
    }

    @Test
    void printList() {
    }
}