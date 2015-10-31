package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

// Created by Ethan on 9/18/2015.
public class TownController {

    @FXML
    void usePub(MouseEvent event) {
        Game.instance.gamble();

    }

    @FXML
    void useAssay(MouseEvent event) {
        Game.instance.useAssay();

    }

    @FXML
    void useLand(MouseEvent event) {
        Game.instance.useLandOffice();

    }

    public void showMap() {
        ScreenNavigator.instance.loadMain();
    }

    public void leaveTown(MouseEvent event) {
        String side = ((Node)event.getSource()).getId();
        Game.instance.leaveTown(side);
        ScreenNavigator.instance.loadMap();
    }

    @FXML
    void enterStore(MouseEvent event) {
        Game.instance.enterStore();
    }

    @FXML
    private void handleLoadGame(ActionEvent e) {
        Game.instance.loadGame();
    }
    @FXML
    private void handleSaveGame(ActionEvent e) {
        Game.instance.saveGame();
    }
    @FXML
    private void closeGame(ActionEvent e) {
        Game.instance.timer.stopTime();
        System.exit(0);
    }
}
