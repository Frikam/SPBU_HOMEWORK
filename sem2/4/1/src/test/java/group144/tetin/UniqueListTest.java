package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueListTest {
    @Test
    void add() throws AlreadyInListException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        assertEquals("1 2 5 ", list.printList());
    }

    @Test
    void addSimilarElement() throws AlreadyInListException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(5);
        assertThrows(AlreadyInListException.class, () -> list.add(5));
    }

    @Test
    void addElementWithIndex() throws AlreadyInListException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(1);
        list.add(3);
        list.add(2, 1);
        assertEquals("3 2 1 ", list.printList());
    }
}