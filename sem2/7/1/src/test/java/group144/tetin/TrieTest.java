package group144.tetin;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void addTest() throws WrongSymbolException {
        Trie trie = new Trie();
        trie.add("he");
        trie.add("she");
        trie.add("his");
        trie.add("hers");
        assertTrue(trie.add("he"));
        assertFalse(trie.add("they"));
        assertTrue(trie.add("they"));
    }

    @Test
    public void containsTest() throws WrongSymbolException{
        Trie trie = new Trie();
        trie.add("he");
        trie.add("she");
        trie.add("his");
        trie.add("hers");
        assertTrue(trie.contains("he"));
        assertTrue(trie.contains("she"));
        assertTrue(trie.contains("his"));
        assertTrue(trie.contains("hers"));
        assertFalse(trie.contains("they"));
        assertFalse(trie.contains("h"));
        assertFalse(trie.contains("sh"));
        assertFalse(trie.contains("sher"));
    }

    @Test
    public void howManyStartWithPrefixTest() throws WrongSymbolException {
        Trie trie = new Trie();
        trie.add("he");
        trie.add("she");
        trie.add("his");
        trie.add("hers");
        assertEquals(2, trie.howManyStartWithPrefix("he"));
        assertEquals(3, trie.howManyStartWithPrefix("h"));
        assertEquals(1, trie.howManyStartWithPrefix("she"));
        assertEquals(0, trie.howManyStartWithPrefix("the"));
        trie.remove("he");
        assertEquals(1, trie.howManyStartWithPrefix("he"));
        assertEquals(2, trie.howManyStartWithPrefix("h"));
        trie.remove("hers");
        assertEquals(0, trie.howManyStartWithPrefix("he"));

    }
    @Test
    public void sizeTest() throws WrongSymbolException {
        Trie trie = new Trie();
        assertEquals(0, trie.size());
        trie.add("he");
        assertEquals(1, trie.size());
        trie.add("he");
        assertEquals(1, trie.size());
        trie.add("her");
        assertEquals(2, trie.size());
        trie.remove("her");
        assertEquals(1, trie.size());
    }

    @Test
    public void removeTest() throws WrongSymbolException {
        Trie trie = new Trie();
        assertFalse(trie.remove("he"));
        trie.add("he");
        trie.add("her");
        assertTrue(trie.remove("he"));
        assertFalse(trie.contains("he"));
        assertTrue(trie.remove("her"));
        assertFalse(trie.contains("her"));
    }

    @Test (expected = WrongSymbolException.class)
    public void addElementWithWrongSymbol() throws WrongSymbolException {
        Trie trie = new Trie();
        trie.add("he1");
    }

    @Test
    public void serializeTest() throws WrongSymbolException, IOException, ClassNotFoundException {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("he");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        trie.serialize(outputStream);
        trie.add("she");
        trie.remove("hello");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        trie.deserialize(inputStream);
        assertEquals(2, trie.size());
        assertFalse(trie.contains("she"));
        assertTrue(trie.contains("hello"));
    }
}