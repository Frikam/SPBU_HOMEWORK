package group144.tetin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {
    @Test
    public void horizontalWinX() {
        /**
         * X X X
         * O O .
         * . . .
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "X", ""}, {"O", "O", ""}, {"", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[0][2] = "X";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void horizontalWinO() {
        /**
         * X X .
         * O O O
         * X . .
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "X", ""}, {"O", "O", ""}, {"X", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[1][2] = "O";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }


    @Test
    public void drawTest() {
        /**
         * X X O
         * O O X
         * X X O
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "X", "O"}, {"O", "O", "X"}, {"X", "X", "O"}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void winAfterMove() {
        /**
         * X O .
         * X O .
         * X . .
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "O", ""}, {"X", "O", ""}, {"", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][0] = "X";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void verticalWinX1() {
        /**
         * X O .
         * X O .
         * X . .
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "O", ""}, {"X", "O", ""}, {"", "", "X"}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][1] = "O";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void verticalWinX() {
        /**
         * . O X
         * . O X
         * . . X
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"", "O", "X"}, {"", "O", "X"}, {"", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][2] = "X";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void diagonalWinX1() {
        /**
         * O O X
         * . X .
         * X . .
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"O", "O", "X"}, {"", "X", ""}, {"", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][0] = "X";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }

    @Test
    public void diagonalWinX2() {
        /**
         * X O O
         * . X .
         * . . X
         * */
        TicTacToe TicTacToe = new TicTacToe();
        String[][] textOnButtons = new String[][] {{"X", "O", "O"}, {"", "X", ""}, {"", "", ""}};
        assertFalse(TicTacToe.isAnybodyWin(textOnButtons));
        textOnButtons[2][2] = "X";
        assertTrue(TicTacToe.isAnybodyWin(textOnButtons));
    }
}