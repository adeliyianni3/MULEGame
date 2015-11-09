package MULE.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ConfigScreenController {

    @FXML
    private Label playerNumber;
    @FXML
    private ChoiceBox difficultyChoiceBox;
//    @FXML
//    private ChoiceBox mapChoiceBox;
    @FXML
    private ChoiceBox playerChoiceBox;

    @FXML
    void playerConfiguration() {
        Game.getInstance().setConfigurationSettings(difficulty(), Integer.parseInt((String) playerChoiceBox.getValue()));
    }

    @FXML
    private void handleLoadGame() {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame() {
        Game.getInstance().saveGame();
    }


    private int difficulty() {
        int difficulty;
        switch ((String) difficultyChoiceBox.getValue()) {
            case "Beginner": difficulty = 0;
                break;
            case "Standard": difficulty = 1;
                break;
            case "Tournament": difficulty = 2;
                break;
            default: difficulty = 0;
                break;

        }
        return difficulty;
    }
    @FXML
    private void closeGame() {
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