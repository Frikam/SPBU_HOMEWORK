package group144.tetin;

public class List {
    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }

    }

    private Node head;
    private int length = 0;

    List(){
        head = null;
        int length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // add element in list
    public void add(int value){
        if (head == null){
            head = new Node(value);
        }
        else{
            Node pointer = head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = new Node(value);

        }
        length++;
    }

    // delete last element from list
    public int pop(){
        if (length == 0){
            System.out.println("List is empty");
            return -1;
        }

        if (length == 1){
            length--;
            int result = head.value;
            head = null;
            return result;
        }
        else {
            Node pointer = head;
            while(pointer.next.next != null){
                pointer = pointer.next;
            }
            int result = pointer.next.value;
            pointer.next = null;
            length--;
            return result;
        }
    }


    public void printList(){
        Node pointer = head;
        while (pointer != null){
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
        System.out.println();

    }

    public int getLength(){
        return length;
    }
}
