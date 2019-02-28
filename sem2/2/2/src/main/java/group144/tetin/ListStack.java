package group144.tetin;


public class ListStack <ElementType> implements Stack<ElementType> {

    private class Node{
        private ElementType value;
        private Node next;

        Node(ElementType value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private Node head = null;

    @Override
    public void push(ElementType value) {
        head = new Node(value, head);
        size++;

    }

    @Override
    public ElementType pop() {
        if (isEmpty()){
            return null;
        }
        ElementType result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
