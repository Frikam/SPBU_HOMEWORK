package group144.tetin;

/** A class that represent the Polynomial hash function */
public class PolynomialHash implements HashFunction {
    /** A method that counts polynomial hash function and returns it divided by mod */
    @Override
    public int getHash(String element, int mod) {
        int result = 0;
        int primeNumber = 7;
        int length = element.length();

        for (char symbol : element.toCharArray()) {
            result = (result + (symbol * primeNumber) % mod) % mod;
            primeNumber = (primeNumber * primeNumber) % mod;
        }

        return result;
    }
}
