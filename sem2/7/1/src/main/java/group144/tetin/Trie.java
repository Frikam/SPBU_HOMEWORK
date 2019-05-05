package group144.tetin;

import java.io.*;
import java.util.ArrayList;

/** A class that represent trie data structure */
public class Trie implements Serializable {
    private final int SIZE_OF_ALPHABET = 26;
    private Node head = new Node();
    private int size = 0;
    private ArrayList<String> words = new ArrayList<>();

    /** A method that adds element in trie
     * @throws WrongSymbolException when word have symbol not from alphabetical */
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
        int index;

        for (int i = 0; i < size; i++) {
            index = word.charAt(i) - 'a';
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }

            current.next[index].numberOfPrefix++;

            if (i == word.length() - 1) {
                current.next[index].isTerminal = true;
                words.add(word);
            }
            else {
                current = current.next[index];
            }
        }

        return isContains;
    }


    /** A method that removes elements from trie */
    public boolean remove(String word) throws WrongSymbolException {
        boolean isContains = contains(word);

        if (!isContains) {
            return false;
        }
        else {
            size--;
        }

        int size = word.length();
        Node current = head;
        Node previous;
        int index;

        for (int i = 0; i < size; i++) {
            index = word.charAt(i) - 'a';
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }

            if (current.next[index] == null) {
                return false;
            }
            previous = current;
            current = current.next[index];
            current.numberOfPrefix--;

            if (current.numberOfPrefix == 0) {
                previous = null;
            }
        }

        current.isTerminal = false;

        return isContains;
    }

    /** A method that checks element in trie or no */
    public boolean contains(String word) throws WrongSymbolException {
        int size = word.length();
        Node current = head;
        int index;

        for (int i = 0; i < size; i++) {
            index = word.charAt(i) - 'a';
            if (isWrongSymbol(word.charAt(i))) {
                throw new WrongSymbolException();
            }

            if (current.next[index] == null) {
                return false;
            }
            current = current.next[index];
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

    /** A method that return size of trie */
    public int size() {
        return size;
    }

    /** A method that puts object in output stream to save it */
    public void serialize(OutputStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (int i = 0; i < words.size(); i++) {
            writer.write(words.get(i));
            writer.write("\n");
        }

        writer.close();
    }

    /** A method that gets object from input stream and replace current one with it */
    public void deserialize(InputStream in) throws IOException, WrongSymbolException {
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        Trie trie = new Trie();

        while (input.ready()) {
            trie.add(input.readLine());
        }

        head = trie.head;
        size = trie.size;

        input.close();
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
