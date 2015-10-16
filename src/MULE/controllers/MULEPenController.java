package MULE.controllers;

import MULE.models.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ethan on 10/1/2015.
 */
public class MULEPenController {

    @FXML
    void foodMULE(MouseEvent event) {
        Game.buyMULE(new Food());
    }

    @FXML
    void energyMULE(MouseEvent event) {
        Game.buyMULE(new Energy());
    }

    @FXML
     void crystaliteMULE(MouseEvent event) {
        Game.buyMULE(new Crystite());
    }

    @FXML
    void smithoreMULE(MouseEvent event) {
        Game.buyMULE(new SmithOre());
    }

    @FXML
    void returnToStore(MouseEvent event) {
        ScreenNavigator.instance.loadStore();
    }



}
