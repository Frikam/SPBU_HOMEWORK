package group144.tetin;

public class UniqueList<ElementType> extends List<ElementType> {
    void add(ElementType value) throws AlreadyInListException {
        if (!ElementInList(value)){
            throw new AlreadyInListException();
        }

        super.add(value);
    }

    void add(ElementType value, int index) throws AlreadyInListException, WrongIndexException {
        if (ElementInList(value)){
            throw new AlreadyInListException();
        }

        super.add(value, index);
    }

}
