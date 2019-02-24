package group144.tetin;

public class main {
    public static void main(String args[]){
        Stack stack = new Stack();
        System.out.println("Hello");
        stack.add(5);
        stack.add(10);
        System.out.println("Size : " + stack.getSize());
        System.out.println("Deleted element : " + stack.pop());
        System.out.println("Size : " + stack.getSize());
        System.out.println("Deleted element : " + stack.pop());
        System.out.println("Stack is empty : " + stack.isEmpty());
    }
}
