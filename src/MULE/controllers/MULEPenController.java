package MULE.controllers;

import MULE.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

// Created by Ethan on 10/1/2015.
public class MULEPenController {

    @FXML
    void foodMULE(MouseEvent event) {
        Game.getInstance().buyMULE(new Food());
    }

    @FXML
    void energyMULE(MouseEvent event) {
        Game.getInstance().buyMULE(new Energy());
    }

    @FXML
     void crystaliteMULE(MouseEvent event) {
        Game.getInstance().buyMULE(new Crystite());
    }

    @FXML
    void smithoreMULE(MouseEvent event) {
        Game.getInstance().buyMULE(new SmithOre());
    }

    @FXML
    void returnToStore(MouseEvent event) {
        ScreenNavigator.getInstance().loadStore();
    }

    @FXML
    private void handleLoadGame(ActionEvent e) {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame(ActionEvent e) {
        Game.getInstance().saveGame();
    }
    @FXML
    private void closeGame(ActionEvent e) {
        Game.getInstance().timer.stopTime();
        System.exit(0);
    }
    @FXML
    private void pauseMusic(ActionEvent e) {
        Game.getInstance().pauseMusic();
    }
    @FXML
    private void playMusic(ActionEvent e) {
        Game.getInstance().playMusic();
    }

}
