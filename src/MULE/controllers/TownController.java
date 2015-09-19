package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ethan on 9/18/2015.
 */
public class TownController {

    @FXML
    void storeClick(MouseEvent event) {
        String storeName = ((Node)event.getSource()).getId();
        //add in interaction with main here
        //landName will contain a string "RC" containing store's row and column in the set 2x2 array
    }

    public void showMap() {
        ScreenNavigator.loadMain();
    }
}
