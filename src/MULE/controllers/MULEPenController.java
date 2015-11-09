package MULE.controllers;

import MULE.models.*;
import javafx.fxml.FXML;

// Created by Ethan on 10/1/2015.
public class MULEPenController {

    @FXML
    void foodMULE() {
        Game.getInstance().buyMULE(new Food());
    }

    @FXML
    void energyMULE() {
        Game.getInstance().buyMULE(new Energy());
    }

    @FXML
     void crystaliteMULE() {
        Game.getInstance().buyMULE(new Crystite());
    }

    @FXML
    void smithoreMULE() {
        Game.getInstance().buyMULE(new SmithOre());
    }

    @FXML
    void returnToStore() {
        ScreenNavigator.getInstance().loadStore();
    }

    @FXML
    private void handleLoadGame() {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame() {
        Game.getInstance().saveGame();
    }
    @FXML
    private void closeGame() {
        Game.getInstance().timer.stopTime();
        System.exit(0);
    }
    @FXML
    private void pauseMusic() {
        Game.getInstance().pauseMusic();
    }
    @FXML
    private void playMusic() {
        Game.getInstance().playMusic();
    }

}
