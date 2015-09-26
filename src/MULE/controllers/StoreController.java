package MULE.controllers;

import MULE.models.Game;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Created by Antonia on 9/26/2015.
 */
public class StoreController {
    public void leaveStore(MouseEvent event) {
        String side = ((Node)event.getSource()).getId();
        Game.leaveStore(side);
        ScreenNavigator.instance.loadTown();
    }
    public void showMap() {
        ScreenNavigator.instance.loadMain();
    }
}
