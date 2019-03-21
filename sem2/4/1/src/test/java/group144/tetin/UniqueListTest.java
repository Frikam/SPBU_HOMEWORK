package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueListTest {

    @Test
    void ListWithUniqueElements() throws AlreadyInListException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        assertEquals("1 2 5", list.printList());
    }

    @Test
    void AddInListSimilarElement() throws AlreadyInListException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(5);
        assertThrows(AlreadyInListException.class, () -> list.add(5));
    }

    void DeleteElementFromEmptyList() throws ElementNotFoundException {
        UniqueList<Integer> list = new UniqueList<>();
        assertThrows(ElementNotFoundException.class, () -> list.remove(5));
    }
}