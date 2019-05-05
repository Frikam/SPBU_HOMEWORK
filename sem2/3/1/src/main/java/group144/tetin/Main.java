package group144.tetin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word;
        Scanner in = new Scanner(System.in);
        HashTable hashTable = new HashTable(200, chooseHashFunction(in));
        printMenu();
        int command = 1;

        while (command != 0) {
            System.out.print("Enter number of command : ");
            command = in.nextInt();
            switch (command) {
                case 0:
                    break;
                case 1:
                    try {
                        System.out.print("Enter word : ");
                        word = in.next();
                        hashTable.add(word);
                        System.out.println("Element added");
                    } catch (AlreadyInHashTableException e) {
                        System.out.println("Word already in hash table");
                    }
                    break;
                case 2:
                    System.out.print("Enter word : ");
                    word = in.next();
                    try {
                        hashTable.delete(word);
                        System.out.println("Element deleted");
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("Element not found!");
                    }
                    break;
                case 3:
                    System.out.println(hashTable.getLoadFactor());
                    break;
                case 4:
                    System.out.println(hashTable.getConflictNumber());
                    break;
                case 5:
                    System.out.println(hashTable.getMaxLengthOfList());
                    break;
                case 6:
                    System.out.println(hashTable.getElementNumber());
                    break;
                case 7:
                    hashTable.changeHashFunction(new PolynomialHash());
                    break;
                case 8:
                    hashTable.changeHashFunction(new SymbolsMultiplicationHash());
                    break;
                case 9:
                    hashTable.changeHashFunction(new SquaredLengthHash());
                    break;
                case 10:
                    printFullStatistic(hashTable);
                    break;
                case 11:
                    try {
                        readFile(hashTable);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (AlreadyInHashTableException e) {
                        System.out.println("File has same words");
                    }

                    break;
                case 12:
                    System.out.print("Enter word : ");
                    word = in.next();
                    System.out.println("Element in hash table : " + hashTable.contains(word));
                    break;
                default:
                    System.out.println("Wrong number of command, try again");
            }
        }
    }

    /** A method that prints menu */
    public static void printMenu() {
        System.out.println("0 - exit the program");
        System.out.println("1 - add element in the hashtable");
        System.out.println("2 - delete element from the hashtable");
        System.out.println("3 - prints load factor in the hashtable");
        System.out.println("4 - prints number of conflicts in the hashtable");
        System.out.println("5 - prints max length of conflict cells");
        System.out.println("6 - print the number of elements in the table");
        System.out.println("7 - choose polynomial hash function");
        System.out.println("8 - choose symbols multiplication hash function");
        System.out.println("9 - choose squared length hash function");
        System.out.println("10 - print full statistic");
        System.out.println("11 - add all elements from file");
        System.out.println("12 - checks element in hash table or no");
    }

    /** A method where you choose hash function */
    public static HashFunction chooseHashFunction(Scanner in) {
        final boolean isWrongNumberOfCommand = true;
        System.out.println("1 - choose polynomial hash function");
        System.out.println("2 - choose symbols multiplication hash function");
        System.out.println("3 - choose symbols multiplication hash function");
        while (isWrongNumberOfCommand) {
            System.out.print("Enter number of command : ");
            switch (in.next()) {
                case "1":
                    return new PolynomialHash();
                case "2":
                    return new SymbolsMultiplicationHash();
                case "3":
                    return new SquaredLengthHash();
                default:
                    System.out.println("Wrong number of command, try again");
            }
        }
    }

    /** A method that adds all words from a file to hash table */
    public static void readFile(HashTable hashTable) throws AlreadyInHashTableException, FileNotFoundException {
        try {
            Scanner file = new Scanner (new File("input.txt"));

            while (file.hasNext()) {
                hashTable.add(file.next());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (AlreadyInHashTableException e) {
            throw new AlreadyInHashTableException();
        }
    }

    /** A method that prints load factor, number of conflicts, max length of conflict cells, number of elements */
    public static void printFullStatistic(HashTable hashTable) {
        System.out.println("Load factor : " + hashTable.getLoadFactor());
        System.out.println("Number of conflicts : " + hashTable.getConflictNumber());
        System.out.println("Max length of conflict cells : " + hashTable.getMaxLengthOfList());
        System.out.println("Number of elements : " + hashTable.getElementNumber());
    }
}
