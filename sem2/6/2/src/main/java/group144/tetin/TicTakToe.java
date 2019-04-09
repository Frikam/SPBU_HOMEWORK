package group144.tetin;


import javafx.scene.control.Button;

public class TicTakToe {
    public boolean isAnybodyWin(Button[][] buttons) {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().equals("") && buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][1].getText() == buttons[i][2].getText()) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!buttons[0][i].getText().equals("") && buttons[0][i].getText() == buttons[1][i].getText() && buttons[1][i].getText() == buttons[2][i].getText()) {
                return true;
            }
        }

        if (!buttons[0][0].getText().equals("") && buttons[0][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][2].getText()) {
            return true;
        }

        if (!buttons[2][0].getText().equals("") && buttons[2][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[0][2].getText()) {
            return true;
        }

        return false;
    }
}
