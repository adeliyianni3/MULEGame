package MULE.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ConfigScreenController {

    @FXML
    private Label playerNumber;
    @FXML
    private ChoiceBox difficultyChoiceBox;
    @FXML
    private ChoiceBox mapChoiceBox;
    @FXML
    private ChoiceBox playerChoiceBox;

    @FXML
    void playerConfiguration() {
        Game.getInstance().setConfigurationSettings(map(), difficulty(), Integer.parseInt((String) playerChoiceBox.getValue()));
    }

    @FXML
    private void handleLoadGame() {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame() {
        Game.getInstance().saveGame();
    }


    private Diffuculty difficulty() {
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
        Diffuculty[] choices = {Diffuculty.BEGINNER, Diffuculty.STANDARD, Diffuculty.TOURNAMENT};
        return choices[difficulty];
    }
    private int map() {
        int map;
        switch ((String) mapChoiceBox.getValue()) {
            case "Map 1": map = 1;
                break;
            case "Map 2": map = 2;
                break;
            case "Map 3": map = 2;
                break;
            default: map = 1;
                break;

        }
        return map;
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