package group144.tetin;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    public void addTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        assertEquals(2, hashTable.getElementNumber());
    }

    @Test
    public void deleteTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        hashTable.delete("Berserk");
        assertEquals(1, hashTable.getElementNumber());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteExceptionTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        hashTable.delete("Flower");
    }

    @Test
    public void getElementNumberTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        assertEquals(2, hashTable.getElementNumber());
        hashTable.delete("Berserk");
        assertEquals(1, hashTable.getElementNumber());
        hashTable.delete("Spb");
        assertEquals(0, hashTable.getElementNumber());
    }

    @Test
    public void getConflictNumberTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Berserk");
        hashTable.add("Spb");
        assertEquals(0, hashTable.getConflictNumber());
    }

    @Test
    public void getMaxListSizeTest() throws ElementNotFoundException, AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Berserk");
        hashTable.add("Flower");
        assertEquals(1, hashTable.getMaxLengthOfList());
    }

    @Test
    public void containsTest() throws AlreadyInHashTableException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Flower");
        hashTable.add("Berserk");
        assertTrue(hashTable.contains("Berserk"));
        hashTable.delete("Berserk");
        assertFalse(hashTable.contains("Berserk"));
    }
}