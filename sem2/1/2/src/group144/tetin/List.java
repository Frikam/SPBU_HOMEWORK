package group144.tetin;

/** Singly connected list */
 public class List {
    private Node head;
    private int length = 0;

    public boolean isEmpty() {
        return length == 0;
    }

    /** Add element in list */
    public void push(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(value);
        length++;
    }

    /** Delete last element from list */
    public int pop() {
        if (length == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (length == 1) {
            length--;
            int result = head.value;
            head = null;
            return result;
        }

        Node pointer = head;
        while(pointer.next.next != null) {
            pointer = pointer.next;
        }
        int result = pointer.next.value;
        pointer.next = null;
        length--;
        return result;
    }


    public void printList() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
        System.out.println();

    }

    public int getLength() {
        return length;
    }

    private class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }

    }
}
