package group144.tetin;

public class Main {
    public static void main(String[] args){
        List list = new List();
        list.add(1);
        list.printList();
        list.add(2);
        list.printList();
        System.out.println("Length : " + list.getLength());
        System.out.println("Deleted element : " + list.pop());
        System.out.println("Deleted element : " + list.pop());
        System.out.println("List is empty : "+ list.isEmpty());
        System.out.println("Length : " + list.getLength());
    }
}
