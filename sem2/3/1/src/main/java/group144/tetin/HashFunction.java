package group144.tetin;

/** An interface that describes hash function for hash table */
public interface HashFunction {
    /** A method that calculate hash function */
    int getHash(String element, int mod);
}
