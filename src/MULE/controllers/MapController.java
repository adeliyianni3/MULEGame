package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


/**
 * Created by Ethan on 9/18/2015.
 */
public class MapController {

    @FXML
    void landClick(ActionEvent event) {
        String landName = ((Node)event.getSource()).getId();
        //add in interaction with main here
        //landName will contain a string "RC" containing land's row and column in the set 5x5 array
    }
}
