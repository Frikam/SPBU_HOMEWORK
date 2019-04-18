package group144.tetin;

import java.io.*;

public class Bor implements Serializable {
    private final int SIZE_OF_ALPHABET = 26;
    private Node head = new Node();
    private int size = 0;

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

    public boolean remove(String word) {
        boolean isContains = contains(word);

        if (isContains) {
            size--;
        }
        else {
            return false;
        }

        int size = word.length();
        Node current = head;
        Node previous = null;

        for (int i = 0; i < size; i++) {
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

    public boolean contains(String word) {
        int size = word.length();
        Node current = head;

        for (int i = 0; i < size; i++) {
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

    public int howManyStartWithPrefix(String prefix) {
        int result = 0;
        int size = prefix.length();
        Node current = head;


        for (int i = 0; i < size; i++) {
            if (current == null) {
                return result;
            }
            current = current.next[prefix.charAt(i) - 'a'];
        }

        return current.numberOfPrefix;
    }

    public int size() {
        return size;
    }

    public void serialize(OutputStream out) throws IOException {
        ObjectOutputStream object = new ObjectOutputStream(out);
        object.writeObject(this);
    }

    public void deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(in);
        Bor newTrie = (Bor) object.readObject();
        this.head = newTrie.head;
    }


    private class Node implements Serializable {
        private Node[] next = new Node[SIZE_OF_ALPHABET];
        private boolean isTerminal = false;
        private int numberOfPrefix = 0;
    }
}
