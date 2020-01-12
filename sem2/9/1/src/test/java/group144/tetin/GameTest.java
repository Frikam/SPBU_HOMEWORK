package group144.tetin;

import javafx.scene.control.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void horizontalWinX() {
        /**
         * X X X
         * O O .
         * . . .
         * */
        Game game = new Game();
        game.turn(0, 0);
        game.turn(1, 0);
        game.turn(0, 1);
        game.turn(1, 1);
        assertFalse(game.isAnybodyWin());
        game.turn(0, 2);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("X_WON"));
    }

    @Test
    public void horizontalWinO() {
        /**
         * X X .
         * O O O
         * X . .
         * */
        Game game = new Game();
        game.turn(0, 0);
        game.turn(1, 0);
        game.turn(0, 2);
        game.turn(1, 1);
        game.turn(2, 0);
        assertFalse(game.isAnybodyWin());
        game.turn(1, 2);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("O_WON"));
    }


    @Test
    public void drawTest() {
        /**
         * X X O
         * O O X
         * X X O
         * */
        Game game = new Game();
        game.turn(0, 0);
        game.turn(1, 0);
        game.turn(0, 2);
        game.turn(1, 1);
        game.turn(2, 0);
        game.turn(0, 2);
        game.turn(1, 2);
        game.turn(2, 2);
        game.turn(2, 1);
        assertFalse(game.isAnybodyWin());
        assertTrue(game.state().equals("DRAW"));
    }

    @Test
    public void winAfterMove() {
        /**
         * X O .
         * X O .
         * X . .
         * */
        Game game = new Game();
        game.turn(0, 0);
        game.turn(0, 1);
        game.turn(1, 0);
        game.turn(1, 1);
        assertFalse(game.isAnybodyWin());
        game.turn(2, 0);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("X_WON"));
    }

    @Test
    public void verticalWinX() {
        /**
         * . O X
         * . O X
         * . . X
         * */
        Game game = new Game();
        game.turn(0, 2);
        game.turn(0, 1);
        game.turn(1, 2);
        game.turn(1, 1);
        game.turn(2, 2);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("X_WON"));
    }

    @Test
    public void diagonalWinX1() {
        /**
         * O O X
         * . X .
         * X . .
         * */
        Game game = new Game();
        game.turn(0, 2);
        game.turn(0, 1);
        game.turn(1, 1);
        game.turn(0, 0);
        game.turn(2, 0);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("X_WON"));
    }

    @Test
    public void diagonalWinX2() {
        /**
         * X O O
         * . X .
         * . . X
         * */
        Game game = new Game();
        game.turn(0, 0);
        game.turn(0, 1);
        game.turn(1, 1);
        game.turn(0, 2);
        game.turn(2, 2);
        assertTrue(game.isAnybodyWin());
        assertTrue(game.state().equals("X_WON"));
    }
}