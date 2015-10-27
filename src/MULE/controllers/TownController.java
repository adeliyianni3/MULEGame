package MULE.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ethan on 9/18/2015.
 */
public class TownController {

    @FXML
    void usePub(MouseEvent event) {
        Game.gamble();

    }

    @FXML
    void useAssay(MouseEvent event) {
        Game.storeClicked("pub");

    }

    @FXML
    void useLand(MouseEvent event) {
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
        Game.enterStore();
    }
}
