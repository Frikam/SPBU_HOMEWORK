package group144.tetin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTakToeTest {
    @Test
    public void isAnybodyWinTest1() {
        /**
         * X X X
         * O O .
         * . . .
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "X", ""}, {"O", "O", ""}, {"", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[0][2] = "X";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest2() {
        /**
         * X X .
         * O O O
         * X . .
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "X", ""}, {"O", "O", ""}, {"X", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[1][2] = "O";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }


    @Test
    public void isAnybodyWinTest3() {
        /**
         * X X O
         * O O X
         * X X O
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "X", "O"}, {"O", "O", "X"}, {"X", "X", "O"}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest4() {
        /**
         * X X O
         * O O X
         * X X O
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "X", "O"}, {"O", "O", "X"}, {"X", "X", "O"}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest5() {
        /**
         * X X O
         * O O X
         * X X O
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "X", "O"}, {"O", "O", "X"}, {"X", "X", "O"}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest6() {
        /**
         * X O .
         * X O .
         * X . .
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "O", ""}, {"X", "O", ""}, {"", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][0] = "X";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest7() {
        /**
         * X O .
         * X O .
         * X . .
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "O", ""}, {"X", "O", ""}, {"", "", "X"}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][1] = "O";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest8() {
        /**
         * . O X
         * . O X
         * . . X
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"", "O", "X"}, {"", "O", "X"}, {"", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][2] = "X";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest9() {
        /**
         * O O X
         * . X .
         * X . .
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"O", "O", "X"}, {"", "X", ""}, {"", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][0] = "X";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void isAnybodyWinTest10() {
        /**
         * X O O
         * . X .
         * . . X
         * */
        TicTakToe ticTakToe = new TicTakToe();
        String[][] textOnButtons = new String[][] {{"X", "O", "O"}, {"", "X", ""}, {"", "", ""}};
        assertFalse(ticTakToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][2] = "X";
        assertTrue(ticTakToe.isAnybodyWin(textOnButtons));
    }
}