package Mule.Controllers;

import Mule.Models.Player;
import Mule.Models.Race;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

import java.awt.*;

/**
 * Created by Ethan on 9/10/2015.
 */
public class PlayerController {

    private StringProperty whichPlayer;
    @FXML
    private Label playerNumber;
    @FXML
    private ChoiceBox playerRace;
    @FXML
    private TextField playerName;
    @FXML
    private ColorPicker playerColor;

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    public PlayerController() {
        whichPlayer = new SimpleStringProperty();
        setWhichPlayer("Player 1");
    }

    public String getWhichPlayer() {
        return whichPlayer.get();
    }

    public StringProperty whichPlayerProperty() {
        return whichPlayer;
    }

    public void setWhichPlayer(String whichPlayer) {
        this.whichPlayer.set(whichPlayer);
    }

    @FXML
    void back(ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.MAIN_SCREEN);
    }

    @FXML
    void submit(ActionEvent event) {
        String name = playerName.getText();
        String mRace = (String) playerRace.getValue();
        Race race = null;
        switch (mRace) {
            case "Packer":
                race = Race.PACKER;
                break;
            case "Sheroid":
                race = Race.SHEROID;
                break;
            case "Humanoid":
                race = Race.HUMANOID;
                break;
            case "Leggite":
                race = Race.LEGGITE;
                break;
            case "Flapper":
                race = Race.FLAPPER;
                break;
            case "Bonzoid":
                race = Race.BONZOID;
                break;
            case "Mechton":
                race = Race.MECHTRON;
                break;
            case "Gollumer":
                race = Race.GOLLUMER;
                break;
        }
        Main.players[Main.playerConfiguration] = new Player(name, race, Color.BLUE);
        System.out.println(Main.players[Main.playerConfiguration]);
        setWhichPlayer("Player " + Main.playerConfiguration + 1);
        if (Main.playerConfiguration <  Main.numOfPlayers){
                Main.playerConfiguration++;
                ScreenNavigator.loadScreen(ScreenNavigator.PLAYER);
        } else {
            ScreenNavigator.loadScreen(ScreenNavigator.CONGRATULATIONS);
        }

    }
}
