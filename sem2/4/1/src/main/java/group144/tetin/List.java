package group144.tetin;

public class List<ElementType> {
    private Node head = null;
    private int size = 0;

    void add(ElementType value) throws AlreadyInListException {
        if (size == 0) {
            head = new Node(value);
            size++;
            return;
        }
        else {
            head = new Node(value, head);
            size++;
        }
    }

    void add(ElementType value, int index) throws AlreadyInListException, WrongIndexException  {
        if (size == 0 || index == 0) {
            head = new Node(value, head.next);
            size++;
            return;
        }
        else {
            Node current = head;
            int count = 0;
            if (index >= size) {
                throw new WrongIndexException();
            }

            while(count + 1 != index) {
                count++;
                current = current.next;
            }

            current.next = new Node(value, current.next);
            size++;
        }
    }

    void remove(ElementType value) throws EmptyListException {
        if (size == 0) {
            throw new EmptyListException();
        }

        if (size == 1) {
            size--;
            head = null;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != value) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        size--;
    }

    void remove(ElementType value, int index) throws EmptyListException {
        if (size == 0) {
            throw new EmptyListException();
        }

        size--;

        if (size == 1){
            head = null;
            return;
        }

        Node current = head;
        int count = 0;

        while(count + 1 != index) {
            count++;
            current = current.next;
        }

        if (size == index - 1){
            current.next = null;
            return;
        }

        current.next = current.next.next;
    }

    public boolean ElementInList(ElementType element) {
        Node current = head;

        while(current != null) {
            if (current.value.equals(element)) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public String printList() {
        Node current = head;
        String result = "";

        while (current != null){
            System.out.print(current.value + " ");
            result += current.value + " ";
            current = current.next;
        }

        return result;
    }


    private class Node {
        ElementType value;
        private Node next;

        Node(ElementType value, Node node){
            this.value = value;
            this.next = node;
        }

        Node(ElementType value){
            this.value = value;
            this.next = null;
        }
    }
}
