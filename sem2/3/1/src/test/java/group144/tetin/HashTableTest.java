package group144.tetin;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void addTest() {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        assertEquals(2, hashTable.getElementNumber());
    }

    @Test
    public void deleteTest() {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        hashTable.delete("Berserk");
        assertEquals(1, hashTable.getElementNumber());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteExceptionTest()    {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Spb");
        hashTable.add("Berserk");
        hashTable.delete("Flower");
    }

    @Test
    public void getElementNumberTest() {
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
    public void getConflictNumberTest() {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Berserk");
        hashTable.add("Spb");
        assertEquals(0, hashTable.getConflictNumber());
        hashTable.add("Berserk");
        assertEquals(1, hashTable.getConflictNumber());
    }

    @Test
    public void getMaxListSizeTest() throws ElementNotFoundException {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Berserk");
        hashTable.add("Berserk");
        hashTable.add("Flower");
        assertEquals(2, hashTable.getMaxLengthOfList());
        hashTable.add("Flower");
        hashTable.add("Flower");
        assertEquals(3, hashTable.getMaxLengthOfList());
    }

    @Test
    public void containsTest() {
        HashTable hashTable = new HashTable(200, new PolynomialHash());
        hashTable.add("Flower");
        hashTable.add("Berserk");
        assertTrue(hashTable.contains("Berserk"));
        hashTable.delete("Berserk");
        assertFalse(hashTable.contains("Berserk"));
    }
}
