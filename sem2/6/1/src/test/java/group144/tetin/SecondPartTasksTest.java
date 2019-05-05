package group144.tetin;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        List<String> list = Arrays.asList("hello just", "my name is ilya", "and im just trying to learn java", "just juice", "java");
        assertEquals(Arrays.asList("hello just", "and im just trying to learn java", "just juice"), SecondPartTasks.findQuotes(list, "just"));
        assertEquals(Arrays.asList("and im just trying to learn java", "java"), SecondPartTasks.findQuotes(list, "java"));
    }

    @Test
    public void testPiDividedBy4() {
        double PI = (double) 22 / (double) 7;
        assertEquals(PI / 4, SecondPartTasks.piDividedBy4(), 0.01);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();

        List<String> vasya = Arrays.asList("abc", "aaa", "bc");
        compositions.put("Vasya", vasya);

        List<String> petya = Arrays.asList("ab", "aa", "b");
        compositions.put("Petya", petya);

        List<String> ilya = Arrays.asList("abcde", "aads", "b");
        compositions.put("Ilya", ilya);

        assertEquals("Ilya", SecondPartTasks.findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        List<Map<String, Integer>> orders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orders.add(new HashMap<>());
        }

        orders.get(0).put("Bread", 100);
        orders.get(0).put("Coconut oil", 20);
        orders.get(0).put("Chocolate", 200);

        orders.get(1).put("Bear", 500);
        orders.get(1).put("Coconut oil", 10);
        orders.get(1).put("Bread", 100);

        orders.get(2).put("Bear", 500);
        orders.get(2).put("Wine", 100);
        orders.get(2).put("Vodka", 500);

        Map<String, Integer> finallyOrders = new HashMap<>();
        finallyOrders.put("Bread", 200);
        finallyOrders.put("Coconut oil", 30);
        finallyOrders.put("Chocolate", 200);
        finallyOrders.put("Bear", 1000);
        finallyOrders.put("Wine", 100);
        finallyOrders.put("Vodka", 500);

        assertEquals(finallyOrders, SecondPartTasks.calculateGlobalOrder(orders));
    }
}