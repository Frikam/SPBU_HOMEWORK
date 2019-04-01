package group144.tetin;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Controller {
    @FXML
    private Slider slider = new Slider(0, 1, 0.05);

    @FXML
    private ProgressBar progressBar;

    /** A method that sets the value of progress bar when the slider value changes*/
    public void initialize() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> progressBar.progressProperty().setValue(newValue));
    }
}