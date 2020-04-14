package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    @FXML private void initialize() {
        ToggleGroup group = new ToggleGroup();
        radioButton.setToggleGroup(group);
        radioButton2.setToggleGroup(group);
    }
}
