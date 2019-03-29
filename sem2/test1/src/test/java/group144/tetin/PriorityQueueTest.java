package group144.tetin;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    @Test
    public void enqueue() throws EmptyPriorityQueueException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1, 3);
        queue.enqueue(2, 2);
        queue.enqueue(3, 4);
        int result = queue.dequeue();
        assertEquals(3, result);
    }

    @Test
    public void dequeue() throws EmptyPriorityQueueException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1, 3);
        queue.enqueue(2, 2);
        queue.enqueue(3, 4);
        int result = queue.dequeue();
        assertEquals(3, result);
        result = queue.dequeue();
        assertEquals(1, result);
        result = queue.dequeue();
        assertEquals(2, result);
    }

    @Test (expected = EmptyPriorityQueueException.class)
    public void dequeueFromEmptyQueue() throws EmptyPriorityQueueException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.dequeue();
    }

    @Test
    public void isEmptyTest() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("Hello", 5);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void enqueueAndDequeueWithManyElements() throws EmptyPriorityQueueException {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.enqueue("1", 1);
        queue.enqueue("-1", -1);
        queue.enqueue("15", -15);
        queue.enqueue("4", 4);
        queue.enqueue("7", 7);
        queue.enqueue("15", 15);
        assertEquals("15", queue.dequeue());
        assertEquals("7", queue.dequeue());
        queue.enqueue("12", 12);
        assertEquals("12", queue.dequeue());
    }
}