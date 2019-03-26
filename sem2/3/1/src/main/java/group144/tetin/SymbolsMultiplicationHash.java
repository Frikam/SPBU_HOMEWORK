package group144.tetin;

/** A class that represent the symbols multiplication hash function */
public class SymbolsMultiplicationHash implements HashFunction{
    /** A method that symbols multiplication and returns it divided by mod */
    @Override
    public int getHash(String element, int mod) {
        int result = 1;
        for (char symbol : element.toCharArray()) {
            result = (result * symbol) % mod;
        }

        return result;
    }
}
