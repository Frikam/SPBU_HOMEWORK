package group144.tetin;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListStackTest {
    @Test
    public void popTest() throws EmptyStackException{
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        assertTrue(stack.pop().equals(2));
        assertTrue(stack.pop().equals(1));
    }

    @Test
    public void getSizeTest() throws EmptyStackException{
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.getSize());
        stack.pop();
        stack.pop();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void isEmptyTest() throws EmptyStackException{
        Stack<Integer> stack = new ListStack<>();
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void popFromEmptyTest() throws EmptyStackException{
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        assertTrue(stack.pop().equals(1));
        stack.pop();
    }
}