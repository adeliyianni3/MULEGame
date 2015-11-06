package MULE.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import java.net.URL;
import java.util.ResourceBundle;

// Created by Aaron on 9/17/2015.
public class PlayerController implements Initializable{

    private final StringProperty name = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    private void setName(String name) {
        this.name.set(name);
    }

    @FXML
    private void handleLoadGame(ActionEvent e) {
        Game.instance.loadGame();
    }
    @FXML
    private void handleSaveGame(ActionEvent e) {
        Game.instance.saveGame();
    }


    private String race;
    private Color color;

    @FXML
    private ColorPicker colorBox;

    @FXML
    private TextField nameBox;

    private Rectangle previousRace;
    private Rectangle previousColor;


    @FXML
    void toNext(ActionEvent event) {
        String name = nameBox.getText();
        if (!nameBox.getText().isEmpty() && Game.instance.isColorAvailable(color) && race != null) {
            Game.instance.addPlayer(race, color, name);
        } else {
            ScreenNavigator.getInstance().loadErrorMessage();
        }
    }
    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.getInstance().loadMain();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setName("Player " + Game.instance.getTurn());
    }
    @FXML
    private void closeGame(ActionEvent e) {
        System.exit(0);
    }

    public void selectRace(Event e) {
        if (previousRace != null) {
            previousRace.setStroke(Color.TRANSPARENT);
        }
        Rectangle chosen = (Rectangle) e.getSource();
        race = chosen.getId();
        chosen.setStroke(Color.GREENYELLOW);
        previousRace = chosen;
    }

    public void selectColor(Event e) {
        if (previousColor != null) {
            previousColor.setStroke(Color.TRANSPARENT);
        }
        Rectangle chosen = (Rectangle) e.getSource();
        color = (Color) chosen.getFill();
        chosen.setStroke(Color.GREENYELLOW);
        previousColor = chosen;
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
