package group144.tetin;

import java.io.*;

/** A class that represent bor data structure */
public class Bor implements Serializable {
    private final int SIZE_OF_ALPHABET = 26;
    private Node head = new Node();
    private int size = 0;

    /** A method that adds element in bor */
    public boolean add(String word) throws WrongSymbolException {
        boolean isContains = contains(word);

        if (!isContains) {
            size++;
        }
        else {
            return true;
        }

        Node current = head;
        int size = word.length();

        for (int i = 0; i < size; i++) {
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }
            if (current.next[word.charAt(i) - 'a'] == null) {
                current.next[word.charAt(i) - 'a'] = new Node();
            }

            current.next[word.charAt(i) - 'a'].numberOfPrefix++;

            if (i == word.length() - 1) {
                current.next[word.charAt(i) - 'a'].isTerminal = true;
            }
            else {
                current = current.next[word.charAt(i) - 'a'];
            }
        }

        return isContains;
    }

    /** A method that removes elements from bor */
    public boolean remove(String word) throws WrongSymbolException {
        boolean isContains = contains(word);

        if (isContains) {
            size--;
        }
        else {
            return false;
        }

        int size = word.length();
        Node current = head;
        Node previous;

        for (int i = 0; i < size; i++) {
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }

            if (current.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            previous = current;
            current = current.next[word.charAt(i) - 'a'];
            current.numberOfPrefix--;

            if (current.numberOfPrefix == 0) {
                previous = null;
            }
        }

        current.isTerminal = false;

        return isContains;
    }

    /** A method that checks element in bor or no */
    public boolean contains(String word) throws WrongSymbolException {
        int size = word.length();
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }

            if (current.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.next[word.charAt(i) - 'a'];
        }

        if (current.isTerminal == false) {
            return false;
        }

        return true;
    }

    /** A method that counts how many of words start with given prefix */
    public int howManyStartWithPrefix(String prefix) throws WrongSymbolException {
        int result = 0;
        int size = prefix.length();
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (isWrongSymbol(prefix.charAt(i))) {
                throw new WrongSymbolException();
            }

            if (current == null) {
                return result;
            }
            current = current.next[prefix.charAt(i) - 'a'];
        }

        return current.numberOfPrefix;
    }

    /** A method that return size of bor */
    public int size() {
        return size;
    }

    /** A method that puts object in output stream to save it */
    public void serialize(OutputStream out) throws IOException {
        ObjectOutputStream object = new ObjectOutputStream(out);
        object.writeObject(this);
    }

    /** A method that gets object from input stream and replace current one with it */
    public void deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(in);
        Bor newTrie = (Bor) object.readObject();
        this.head = newTrie.head;
    }

    private boolean isWrongSymbol(char symbol) {
        return !(symbol >= 'a' && symbol <= 'z');
    }

    private class Node implements Serializable {
        private Node[] next = new Node[SIZE_OF_ALPHABET];
        private boolean isTerminal = false;
        private int numberOfPrefix = 0;
    }
}
