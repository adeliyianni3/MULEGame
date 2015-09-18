package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Created by Aaron on 9/17/2015.
 */
public class PlayerController {

    @FXML
    private ChoiceBox raceBox;

    @FXML
    private ColorPicker colorBox;

    @FXML
    private TextField nameBox;

    @FXML
    void toNext(ActionEvent event) {
        String race = (String)raceBox.getValue();
        Color c = (Color)colorBox.getValue();
        String name = nameBox.getCharacters().toString();
        ScreenNavigator.loadPlayerConfiguration(race, c, name);
    }
    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.loadMain();
    }

}
