package group144.tetin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/** A class that represent hash table */
public class HashTable {
    private ArrayList<LinkedList<String>> hashTable;
    private HashFunction hashFunction;
    private int elementNumber;
    private int conflictNumber;

    /** A constructor of class HashTable */
    HashTable(int size, HashFunction hashFunction) {
        elementNumber = 0;
        conflictNumber = 0;
        this.hashFunction = hashFunction;
        hashTable = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    /** A method that changes the hash function */
    public void changeHashFunction(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    /** A method that adds the element in hash table
     * @throws AlreadyInHashTableException when adds element that already in hash table
     * */
    public void add(String element) throws AlreadyInHashTableException {
        if (contains(element)) {
            throw new AlreadyInHashTableException();
        }

        int hash = hashFunction.getHash(element, hashTable.size());
        elementNumber++;

        if (hashTable.get(hash).size() != 0) {
            conflictNumber++;
        }

        hashTable.get(hash).add(element);

        if (getLoadFactor() >= 0.75) {
            rebuildHashTable();
        }
    }

    /** A method that rebuild hash table */
    private void rebuildHashTable() throws AlreadyInHashTableException {
        int size = hashTable.size();
        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }

        for (int i = 0; i < size; i++) {
            while (!hashTable.get(i).isEmpty()) {
                add(hashTable.get(i).pop());
            }
        }
    }

    /** A method that checks element in a hash table or no */
    public boolean contains(String element) {
        int hashP = hashFunction.getHash(element, hashTable.size());
        if (hashTable.get(hashP).contains(element)) {
            return true;
        }
        int hashM = new SymbolsMultiplicationHash().getHash(element, hashTable.size());
        if (hashTable.get(hashM).contains(element)) {
            return true;
        }
        int hashD = new SquaredLengthHash().getHash(element, hashTable.size());
        if (hashTable.get(hashD).contains(element)) {
            return true;
        }

        return false;
    }

    /** A method that deletes the element from hash table
     * @throws NoSuchElementException when try we try delete word which is not in hash table
     * */
    public void delete(String element) {
        int hashP = hashFunction.getHash(element, hashTable.size());
        if (hashTable.get(hashP).contains(element)) {
            hashTable.get(hashP).remove(element);
        }
        else {
            int hashM = new SymbolsMultiplicationHash().getHash(element, hashTable.size());
            if (hashTable.get(hashM).contains(element)) {
                hashTable.get(hashM).remove(element);
            }
            else {
                int hashD = new SquaredLengthHash().getHash(element, hashTable.size());
                if (hashTable.get(hashD).contains(element)) {
                    hashTable.get(hashD).remove(element);
                }
                else {
                    throw new NoSuchElementException();
                }
            }
        }
        elementNumber--;
    }

    /** A method that returns number of elements */
    public int getElementNumber() {
        return elementNumber;
    }

    /** A method that returns load factor */
    public double getLoadFactor() {
        return (double) elementNumber / hashTable.size();
    }

    /** A method that returns number of conflicts */
    public int getConflictNumber() {
        return conflictNumber;
    }

    /** A method that returns max length of conflict cell */
    public int getMaxLengthOfList() {
        int result = 0;

        for (LinkedList list : hashTable) {
            result = Math.max(result, list.size());
        }

        return result;
    }
}
