package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ethan on 9/18/2015.
 */
public class MapController {

    @FXML
    void landClick(MouseEvent event) {
        //System.out.println("Ran the landClick method");
        String landName = ((Node)event.getSource()).getId();
        //add in interaction with main here
        //landName will contain a string "RC" containing land's row and column in the set 5x5 array
    }
}
