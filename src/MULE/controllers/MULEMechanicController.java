package MULE.controllers;

import MULE.models.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

// Created by Antonia on 10/1/2015.
public class MULEMechanicController {
    @FXML
    void returnToMap() {
        Game.getInstance().changeState(Game.State.MAP);
        ScreenNavigator.getInstance().loadMap();
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

    public void fixMules(MouseEvent event) {
        Game.getInstance().changeState(Game.State.FIX);
        ScreenNavigator.getInstance().loadMap();
    }
}
