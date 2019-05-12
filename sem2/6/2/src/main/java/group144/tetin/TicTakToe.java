package group144.tetin;


import javafx.scene.control.Button;

public class TicTakToe {
    public boolean isAnybodyWin(String[][] textOnButtons) {
        int numberOfButtons = textOnButtons.length;
        boolean result;
        for (int j = 0; j < numberOfButtons; j++) {
            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!textOnButtons[i][j].equals("") && textOnButtons[i][j].equals(textOnButtons[i + 1][j]))) {
                    result = false;
                }
            }

            if (result == true) {
                return result;
            }

            result = true;
            for (int i = 0; i < numberOfButtons - 1; i++) {
                if (!(!textOnButtons[j][i].equals("") && textOnButtons[j][i].equals(textOnButtons[j][i + 1]))) {
                    result = false;
                }
            }

            if (result == true) {
                return result;
            }
        }

        result = true;
        for (int i = 0; i < numberOfButtons - 1; i++) {
            if (!(!textOnButtons[i][i].equals("") && textOnButtons[i][i].equals(textOnButtons[i + 1][i + 1]))) {
                result = false;
            }
        }

        if (result == true) {
            return result;
        }

        result = true;
        for (int i = numberOfButtons - 1; i > 0; i--) {
            if (!(!textOnButtons[numberOfButtons - 1 - i][i].equals("") && textOnButtons[numberOfButtons - 1 - i][i].equals(textOnButtons[numberOfButtons - i][i - 1]))) {
                result = false;
            }
        }
        if (result == true) {
            return result;
        }

        return false;
    }
}
