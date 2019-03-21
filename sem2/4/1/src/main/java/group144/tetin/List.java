package group144.tetin;

/** A class that represent linked test */
public class List<ElementType> {
    private Node head = null;
    private int size = 0;

    /** Add element in head */
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

    /** Add element to list with certain index */
    void add(ElementType value, int index) throws AlreadyInListException {
        if (size == 0 || index == 0) {
            head = new Node(value, head.next);
            size++;
            return;
        }
        else {
            Node current = head;
            int count = 0;

            while(count + 1 != index || count == size) { // if index more than size, add element to end
                count++;
                current = current.next;
            }

            current.next = new Node(value, current.next);
            size++;
        }
    }

    /** Delete element from list with certain value */
    void remove(ElementType value) throws EmptyListException, ElementNotFoundException {
        if (size == 0) {
            throw new EmptyListException();
        }

        if (!ElementInList(value)){
            throw new ElementNotFoundException();
        }

        if (size == 1) {
            size--;
            head = null;
            return;
        }

        Node current = head;
        Node previous = head;
        previous.next = head; // if we delete element from head

        while (current.value != value) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        size--;
    }

    /** Print list */
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

    protected boolean ElementInList(ElementType element) {
        Node current = head;

        while(current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
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
