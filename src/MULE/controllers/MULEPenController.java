package MULE.controllers;

import MULE.models.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

// Created by Ethan on 10/1/2015.
public class MULEPenController {

    @FXML
    void foodMULE() {
        available.setText("---");
        Game.getInstance().buyMULE(new Food());
    }

    @FXML
    void energyMULE() {
        available.setText("---");
        Game.getInstance().buyMULE(new Energy());
    }

    @FXML
     void crystaliteMULE() {
        available.setText("---");
        Game.getInstance().buyMULE(new Crystite());
    }

    @FXML
    void smithoreMULE() {
        available.setText("---");
        Game.getInstance().buyMULE(new SmithOre());
    }

    @FXML
    void returnToStore() {
        available.setText("---");
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

    @FXML
    public void lumberMULE(Event event) {
        available.setText("---");
        Game.getInstance().buyMULE(new Lumber());
    }

    @FXML
    private Label available;

    @FXML
    public void setAvailable(Event event){
        available.setText(String.valueOf(Game.getInstance().getStore().getMuleInventory()));
    }

    public void oilMULE(Event event) {
        available.setText("---");
        Game.getInstance().buyMULE(new Oil());
    }
}
