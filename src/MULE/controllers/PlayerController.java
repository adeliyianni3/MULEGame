package MULE.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

// Created by Aaron on 9/17/2015.
public class PlayerController implements Initializable{

    private StringProperty name = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
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


    @FXML

    private ChoiceBox raceBox;

    @FXML
    private ColorPicker colorBox;

    @FXML
    private TextField nameBox;

    @FXML
    void toNext(ActionEvent event) {
        String race = (String) raceBox.getValue();
        Color c = colorBox.getValue();
        String name = nameBox.getText();
        if (!nameBox.getText().isEmpty() && Game.isColorAvailable(c)) {
            Game.addPlayer(race, c, name);
        }
    }
    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.instance.loadMain();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setName("Player " + Game.getTurn());
    }
}
