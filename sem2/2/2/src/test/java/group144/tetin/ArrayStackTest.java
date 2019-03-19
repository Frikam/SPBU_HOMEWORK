package group144.tetin;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void popTest() {
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        try {
            assertTrue(stack.pop().equals(2));
            assertTrue(stack.pop().equals(1));
        } catch (EmptyStackException e){
            System.out.print("You cant pop from empty stack!");
        }
    }

    @Test
    public void getSizeTest() {
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.getSize());
        try {
            stack.pop();
            stack.pop();
            assertEquals(0, stack.getSize());
        } catch (EmptyStackException e){
            System.out.print("You cant pop from empty stack!");
        }
    }

    @Test
    public void isEmptyTest() {
        Stack<Integer> stack = new ListStack<>();
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void popFromEmptyTest(){
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        try {
            assertTrue(stack.pop().equals(1));
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.print("You cant pop from empty stack!");
        }

    }

}