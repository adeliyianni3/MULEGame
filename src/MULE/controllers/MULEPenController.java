package MULE.controllers;

import MULE.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

// Created by Ethan on 10/1/2015.
public class MULEPenController {

    @FXML
    void foodMULE(MouseEvent event) {
        Game.instance.buyMULE(new Food());
    }

    @FXML
    void energyMULE(MouseEvent event) {
        Game.instance.buyMULE(new Energy());
    }

    @FXML
     void crystaliteMULE(MouseEvent event) {
        Game.instance.buyMULE(new Crystite());
    }

    @FXML
    void smithoreMULE(MouseEvent event) {
        Game.instance.buyMULE(new SmithOre());
    }

    @FXML
    void returnToStore(MouseEvent event) {
        ScreenNavigator.getInstance().loadStore();
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
    @FXML
    private void pauseMusic(ActionEvent e) {
        Game.instance.pauseMusic();
    }
    @FXML
    private void playMusic(ActionEvent e) {
        Game.instance.playMusic();
    }

}
