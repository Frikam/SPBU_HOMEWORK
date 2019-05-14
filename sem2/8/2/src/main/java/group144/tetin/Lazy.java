package group144.tetin;

/** An interface that represent a lazy calculation */
public interface Lazy<T> {
    /** A method that calculate answer
     * First call of this method calculate answer and others calls just get answer from first call
     * */
    T get();
}