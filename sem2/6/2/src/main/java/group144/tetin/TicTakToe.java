package group144.tetin;


import javafx.scene.control.Button;

public class TicTakToe {
    public boolean isAnybodyWin(Button[][] buttons) {
        int numberOfButtons = buttons.length;
        boolean result = true;
        for (int j = 0; j < numberOfButtons; j++) {
            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!buttons[i][j].getText().equals("") && buttons[i][j].getText().equals(buttons[i + 1][j].getText()))) {
                    result = false;
                }
            }

            if (result == true) {
                return result;
            }

            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!buttons[j][i].getText().equals("") && buttons[j][i].getText().equals(buttons[j][i + 1].getText()))) {
                    result = false;
                }
            }

            if (result == true) {
                return result;
            }
        }

        result = true;
        for (int i = 0; i < numberOfButtons - 1; i++) {
            if (!(!buttons[i][i].getText().equals("") && buttons[i][i].getText().equals(buttons[i + 1][i + 1].getText()))) {
                result = false;
            }
        }

        if (result == true) {
            return result;
        }

        result = true;
        for (int i = numberOfButtons - 1; i > 0; i--) {
            if (!(!buttons[numberOfButtons - 1 - i][i].getText().equals("") && buttons[numberOfButtons - 1 - i][i].getText().equals(buttons[numberOfButtons - i][i - 1].getText()))) {
                System.out.print("Text : " + buttons[i][i].getText());
                result = false;
            }
        }
        if (result == true) {
            return result;
        }

        return false;
    }
}
