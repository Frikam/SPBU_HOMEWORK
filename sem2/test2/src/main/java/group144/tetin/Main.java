package group144.tetin;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] abs) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of lines : ");
        int numberOfArrays = in.nextInt();
        String line = in.nextLine();;
        SortedSet sortedSet = new SortedSet();

        for (int i = 0; i < numberOfArrays; i++) {
            LinkedList<String> list = new LinkedList<>();
            System.out.print("Enter line : ");
            line = in.nextLine();

            for (String word : line.split(" ")) {
                list.add(word);
            }

            sortedSet.add(list);
        }

        sortedSet.print();
    }
}
