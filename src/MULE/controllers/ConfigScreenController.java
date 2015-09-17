package MULE.controllers;


import MULE.models.Game;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class ConfigScreenController {

    //Handling events
    //http://stackoverflow.com/questions/29532247/javafx-pass-parameter-to-the-eventhandler-function-in-fxml-file



    //MULE.models.Player
    private StringProperty playerName = new SimpleStringProperty();
    @FXML
    private Label playerNumber;

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.loadMain();
    }

    @FXML
    void toNext(ActionEvent event) {
        ScreenNavigator.loadPlayerConfiguration();
    }

    //Main Screen
    //http://code.makery.ch/blog/javafx-2-event-handlers-and-change-listeners/
    //http://code.makery.ch/blog/javafx-8-event-handling-examples/
    @FXML
    private ChoiceBox difficultyChoiceBox;
    @FXML
    private ChoiceBox mapChoiceBox;
    @FXML
    private ChoiceBox playerChoiceBox;
//
//    @FXML
//    void setUpChoiceBoxes() {
//        difficultyChoiceBox.setValue("Easy");
//        mapChoiceBox.setValue("Map 1");
//        playerChoiceBox.setValue("1");
//    }


    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    @FXML
    void playerConfiguration(ActionEvent event) {
        Game.numOfPlayers = Integer.parseInt((String)playerChoiceBox.getValue()); //want this to go through navigator, not directly to main

        ScreenNavigator.loadPlayerConfiguration();
    }

    @FXML
    void landClick(ActionEvent event) {
        String landName = ((Node)event.getSource()).getId();
        //add in interaction with main here
        //landName will contain a string "RC" containing land's row and column in the set 5x5 array
    }

    @FXML
    void storeClick(ActionEvent event) {
        String storeName = ((Node)event.getSource()).getId();
        //add in interaction with main here
        //landName will contain a string "RC" containing store's row and column in the set 2x2 array
    }

    //Map
    public void showMap() {
        ScreenNavigator.loadMain();
    }

}