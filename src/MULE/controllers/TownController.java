package MULE.controllers;

import javafx.fxml.FXML;

// Created by Ethan on 9/18/2015.
public class TownController {

    @FXML
    void usePub() {
        Game.instance.gamble();

    }

    @FXML
    void useAssay() {
        Game.instance.useAssay();

    }

    @FXML
    void useLand() {
        Game.instance.useLandOffice();

    }
    @FXML
    private void pauseMusic() {
        Game.instance.pauseMusic();
    }
    @FXML
    private void playMusic() {
        Game.instance.playMusic();
    }
    public void showMap() {
        ScreenNavigator.getInstance().loadMain();
    }

    public void leaveTown() {
        Game.instance.leaveTown();
        ScreenNavigator.getInstance().loadMap();
    }

    @FXML
    void enterStore() {
        Game.instance.enterStore();
    }

    @FXML
    private void handleLoadGame() {
        Game.instance.loadGame();
    }
    @FXML
    private void handleSaveGame() {
        Game.instance.saveGame();
    }
    @FXML
    private void closeGame() {
        Game.instance.timer.stopTime();
        System.exit(0);
    }
}
