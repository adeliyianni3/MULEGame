package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by Aaron on 9/17/2015.
 */
public class PlayerController {

    @FXML
    void toNext(ActionEvent event) {
        ScreenNavigator.loadPlayerConfiguration();
    }
    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.loadMain();
    }

}
