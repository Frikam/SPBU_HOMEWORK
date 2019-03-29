package group144.tetin;

/** A class that represent priority queue with elements in order their priority */
public class PriorityQueue<T> {
    private PriorityQueueNode head;

    /** A method that adds element in queue with given priority */
    public void enqueue(T value, int priority) {
        if (isEmpty()) {
            head = new PriorityQueueNode(value, priority);
            return;
        }

        if (priority > head.priority) {
            head = new PriorityQueueNode(value, priority, head);
            return;
        }

        PriorityQueueNode current = head;
        PriorityQueueNode previous = head;

        while (current.next != null && priority < current.priority) {
            previous = current;
            current = current.next;
        }

        previous.next = new PriorityQueueNode(value, priority, previous.next);
    }

    /** A method that remove element from queue with max priority */
    public T dequeue() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }

        T result = head.value;
        head = head.next;
        return result;
    }

    /** A method that checks the queue for emptiness */
    public boolean isEmpty() {
        return head == null;
    }

    /** A class that represent element from priority queue */
    private class PriorityQueueNode {
        private PriorityQueueNode next;
        private T value;
        private int priority;

        PriorityQueueNode (T value, int priority) {
            this.priority = priority;
            this.value = value;
        }

        PriorityQueueNode (T value, int priority, PriorityQueueNode next) {
            this.priority = priority;
            this.value = value;
            this.next = next;
        }
    }
}
