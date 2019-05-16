package group144.tetin;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class ArithmeticTreeTest {
    @Test
    public void calculateTest(){
        ArithmeticTree tree = new ArithmeticTree(new Scanner("(* 5 (- (* 2 3) 3))"));
        assertEquals(15, tree.calculate());
    }

    @Test
    public void calculateNegativesTest(){
        ArithmeticTree tree = new ArithmeticTree(new Scanner("(* 5 (- (* 2 -3) 3))"));
        assertEquals(-45, tree.calculate());
    }
}