package group144.tetin;

public interface Stack<ElementType> {

    void push(ElementType value);

    ElementType pop();

    boolean isEmpty();

    int getSize();
}
