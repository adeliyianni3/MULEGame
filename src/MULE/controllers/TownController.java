package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

// Created by Ethan on 9/18/2015.
public class TownController {

    @FXML
    void usePub(MouseEvent event) {
        Game.gamble();

    }

    @FXML
    void useAssay(MouseEvent event) {
        Game.useAssay();

    }

    @FXML
    void useLand(MouseEvent event) {
        Game.useLandOffice();

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

    @FXML
    private void handleLoadGame(ActionEvent e) {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame(ActionEvent e) {
        Game.getInstance().saveGame();
    }
}
