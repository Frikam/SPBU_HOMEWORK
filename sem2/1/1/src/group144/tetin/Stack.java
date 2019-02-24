package group144.tetin;


public class Stack {

    private class StackElement{
        int value;
        StackElement next;

        StackElement(int value, StackElement next){
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;
    private int size = 0;

    /*
     * Add element in head
     */

    public void add(int value){
        head = new StackElement(value, head);
        size+=1;
    }

    /*
     * Delete element from head
     */

    public int pop(){
        int result = head.value;
        size-=1;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
}
