package group144.tetin;

/** Class describes game for two players */
public class Game {
    private static final int FIELD_SIZE = 3;
    private int numberOfPressedButtons = 0;
    private Cell[][] field;
    private Player turn;
    private State state;

    public Game() {
        field = new Cell[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = Cell.NOTHING;
            }
        }
        turn = Player.X;
        state = State.PLAYING;
    }

    /**
     * Method put a symbol
     *
     * @param row first coordinate of pos
     * @param column second coordinate of pos
     */
    public void turn(int row, int column) {
        numberOfPressedButtons++;
        field[row][column] = turn.toCell();
        boolean isAnybodyWin = isAnybodyWin();

        if (numberOfPressedButtons == 9) {
            state = State.DRAW;
        }

        setState(isAnybodyWin);
        turn = turn.opposite();
    }

    /** @return Enum state that show what is going on in game */
    public String state() {
        return state.toString();
    }

    /** A method that checks anybody win or no
     * @return true - if anybody win, else return false
     */
    public boolean isAnybodyWin() {
        int numberOfButtons = field.length;
        boolean result;
        for (int j = 0; j < numberOfButtons; j++) {
            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!field[i][j].equals(Cell.NOTHING) && field[i][j].equals(field[i + 1][j]))) {
                    result = false;
                    break;
                }
            }

            if (result) {
                return true;
            }

            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!field[j][i].equals(Cell.NOTHING) && field[j][i].equals(field[j][i + 1]))) {
                    result = false;
                    break;
                }
            }

            if (result) {
                return true;
            }
        }

        result = true;
        for (int i = 0; i < numberOfButtons - 1; i++) {
            if (!(!field[i][i].equals(Cell.NOTHING) && field[i][i].equals(field[i + 1][i + 1]))) {
                result = false;
            }
        }

        if (result) {
            return true;
        }

        result = true;
        for (int i = numberOfButtons - 1; i > 0; i--) {
            if (!(!field[numberOfButtons - 1 - i][i].equals(Cell.NOTHING) && field[numberOfButtons - 1 - i][i].equals(field[numberOfButtons - i][i - 1]))) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Update state if one of players won
     */
    private void setState(boolean isAnyBodyWin) {
        if (isAnyBodyWin) {
            if (turn.toCell().equals(Cell.X)) {
                state = State.X_WON;
                return;
            }
            state = State.O_WON;
        }
    }

    /** Enum of states of game */
    private enum State {
        PLAYING, X_WON, O_WON, DRAW
    }

    /** Enum of all thing that cell of field can become to */
    private enum Cell {X, O, NOTHING}

    /** Enum of players */
    private enum Player {
        X, O;
        public Cell toCell() {return this == Player.X ? Cell.X : Cell.O;}
        public Player opposite() {return this == Player.X ? Player.O : Player.X;}
    }
}
