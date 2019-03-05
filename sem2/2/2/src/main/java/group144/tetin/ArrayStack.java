package group144.tetin;

public class ArrayStack<ElementType> implements Stack<ElementType> {
    private int size = 0;
    private int maxLength = 1000;
    private int currentPosition = 0;
    private ElementType[] array = (ElementType[]) new Object [maxLength];

    @Override
    public void push(ElementType value) {
        array[currentPosition] = value;
        currentPosition++;
    }

    @Override
    public ElementType pop() {
        if (isEmpty()) {
            return null;
        }
        else {
            ElementType result = array[--currentPosition];
            return result;
        }
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
