package group144.tetin;

public interface Stack<ElementType> {
    void push(ElementType value);
    ElementType pop() throws EmptyStackException;
    boolean isEmpty();
    int getSize();
}
