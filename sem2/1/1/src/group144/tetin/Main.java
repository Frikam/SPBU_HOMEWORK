package group144.tetin;

public class Main {
    public static void main (String args[]) {
        Stack stack = new Stack();
        System.out.println("Hello");
        stack.push(5);
        stack.push(10);
        System.out.println("Deleted element : " + stack.pop());
        System.out.println("Deleted element : " + stack.pop());
        System.out.println("Stack is empty : " + stack.isEmpty());
    }
}
