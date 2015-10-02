package MULE.controllers;

import MULE.models.Game;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
        Game.storeClicked(storeName);
        //add in interaction with main here
        //landName will contain a string "RC" containing store's row and column in the set 2x2 array
    }


    @FXML
    void storeClickPub(MouseEvent event) {
        Game.storeClicked("pub");

    }

    public void showMap() {
        ScreenNavigator.instance.loadMain();
    }

    public void leaveTown(MouseEvent event) {
        String side = ((Node)event.getSource()).getId();
        Game.leaveTown(side);
        ScreenNavigator.instance.loadMap();
    }

    @FXML
    void enterStore(MouseEvent event) {
        ScreenNavigator.instance.enterStore();
    }
}
