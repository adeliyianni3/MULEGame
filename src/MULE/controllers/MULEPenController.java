package MULE.controllers;

import MULE.models.Resource;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ethan on 10/1/2015.
 */
public class MULEPenController {

    @FXML
    void foodMULE(MouseEvent event) {
        Game.buyMULE(Resource.FOOD);
    }

    @FXML
    void energyMULE(MouseEvent event) {
        Game.buyMULE(Resource.ENERGY);
    }

    @FXML
     void crystaliteMULE(MouseEvent event) {
        Game.buyMULE(Resource.CRYSTITE);
    }

    @FXML
    void smithoreMULE(MouseEvent event) {
        Game.buyMULE(Resource.SMITH_ORE);
    }

    @FXML
    void returnToStore(MouseEvent event) {
        ScreenNavigator.instance.loadStore();
    }



}