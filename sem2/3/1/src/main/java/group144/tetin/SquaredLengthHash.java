package group144.tetin;

/** A class that represent the squared length hash function */
public class SquaredLengthHash implements HashFunction {
    /** A method that counts the length in a square  and returns it divided by mod */
    @Override
    public int getHash(String element, int mod) {
        return element.length() * element.length() % mod;
    }
}
