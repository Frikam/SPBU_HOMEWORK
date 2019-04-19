package group144.tetin;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class BorTest {
    @Test
    public void addTest() throws WrongSymbolException {
        Bor bor = new Bor();
        bor.add("he");
        bor.add("she");
        bor.add("his");
        bor.add("hers");
        assertTrue(bor.add("he"));
        assertFalse(bor.add("they"));
        assertTrue(bor.add("they"));
    }

    @Test
    public void containsTest() throws WrongSymbolException{
        Bor bor = new Bor();
        bor.add("he");
        bor.add("she");
        bor.add("his");
        bor.add("hers");
        assertTrue(bor.contains("he"));
        assertTrue(bor.contains("she"));
        assertTrue(bor.contains("his"));
        assertTrue(bor.contains("hers"));
        assertFalse(bor.contains("they"));
        assertFalse(bor.contains("h"));
        assertFalse(bor.contains("sh"));
        assertFalse(bor.contains("sher"));
    }

    @Test
    public void howManyStartWithPrefixTest() throws WrongSymbolException {
        Bor bor = new Bor();
        bor.add("he");
        bor.add("she");
        bor.add("his");
        bor.add("hers");
        assertEquals(2, bor.howManyStartWithPrefix("he"));
        assertEquals(3, bor.howManyStartWithPrefix("h"));
        assertEquals(1, bor.howManyStartWithPrefix("she"));
        assertEquals(0, bor.howManyStartWithPrefix("the"));
        bor.remove("he");
        assertEquals(1, bor.howManyStartWithPrefix("he"));
        assertEquals(2, bor.howManyStartWithPrefix("h"));
        bor.remove("hers");
        assertEquals(0, bor.howManyStartWithPrefix("he"));

    }
    @Test
    public void sizeTest() throws WrongSymbolException {
        Bor bor = new Bor();
        assertEquals(0, bor.size());
        bor.add("he");
        assertEquals(1, bor.size());
        bor.add("he");
        assertEquals(1, bor.size());
        bor.add("her");
        assertEquals(2, bor.size());
        bor.remove("her");
        assertEquals(1, bor.size());
    }

    @Test
    public void removeTest() throws WrongSymbolException {
        Bor bor = new Bor();
        assertFalse(bor.remove("he"));
        bor.add("he");
        bor.add("her");
        assertTrue(bor.remove("he"));
        assertFalse(bor.contains("he"));
        assertTrue(bor.remove("her"));
        assertFalse(bor.contains("her"));
    }

    @Test (expected = WrongSymbolException.class)
    public void addElementWithWrongSymbol() throws WrongSymbolException {
        Bor bor = new Bor();
        bor.add("he1");
    }

    @Test
    public void serializeTest() throws WrongSymbolException, IOException, ClassNotFoundException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("he");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bor.serialize(outputStream);
        bor.add("she");
        bor.remove("hello");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        bor.deserialize(inputStream);
        assertEquals(2, bor.size());
        assertFalse(bor.contains("she"));
        assertTrue(bor.contains("hello"));
    }
}