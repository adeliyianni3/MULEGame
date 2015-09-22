package MULE.controllers;

import MULE.models.Game;
import MULE.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class ScreenNavigator {

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN_SCREEN = "/views/mainScreen.fxml";
    public static final String PLAYER = "/views/player.fxml";
    public static final String CONGRATULATIONS = "/views/congratulations.fxml";
    public static final String MAIN = "/views/main.fxml";
    public static final String MAP = "/views/map.fxml";
    public static final String TOWN = "/views/town.fxml";

    public static String currentState;




    /** The main application layout controller. */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        ScreenNavigator.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadScreen(String fxml) {
        try {
            mainController.setVista( //this clears the pane and fills it with the fxml
                    (Node) FXMLLoader.load(
                            ScreenNavigator.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            System.out.println("Could not find file");
            //e.printStackTrace();
        }
    }



    public static void loadMain() {
        loadScreen(MAIN_SCREEN);
        Game.changeState(Game.State.MAIN);
    }

    public static void loadCongratulations() {
        loadScreen(CONGRATULATIONS);
    }

    public static void loadPlayerConfiguration(int i) {
        switch (i) {
            case 2:
                loadScreen(PLAYER);
                break;
            case 3:
                loadScreen(PLAYER);
                break;
            case 4:
                loadScreen(PLAYER);
                break;
            default:
                loadScreen(CONGRATULATIONS);
                break;
        }
    }

    public static void loadPlayerConfiguration() {
        Game.changeState(Game.State.CONFIG);
        //System.out.println(Main.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        loadScreen(PLAYER);
        Game.incrementTurn();
    }

    public static void loadPlayerConfiguration(String race, Color c, String name) {
        System.out.println(Game.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        if (Game.getNumOfPlayers() >= Game.getTurn() && Game.getTotalTurns() == Game.getTurn()) {

            //http://stackoverflow.com/questions/26899197/how-can-a-textfield-from-fxml-file-be-updated-by-settext-in-java-file
//            playerNumber.setText("Player " + Main.playerConfiguration);
//            playerNumber.textProperty().set("Player " + Main.playerConfiguration);
            switch (Game.getTurn()) {
                case 1:
                    loadScreen(PLAYER);
                    break;
                case 2:
                    loadScreen(PLAYER);
                    break;
                case 3:
                    loadScreen(PLAYER);
                    break;
                case 4:
                    loadScreen(PLAYER);
                    break;
                default:
                    loadScreen(CONGRATULATIONS); //replace with something meaningful later
                    break;
            }


        } else {
            loadScreen(MAP);
            Game.changeState(Game.State.BUYPHASE);
        }

        Game.incrementTurn();
    }
    public static void loadMap() {
        loadScreen(MAP);

    }
    public static void setLandColor(String loc, Color c) {

    }

    public static void landClicked(String landLoc) {
        Game.landClicked(landLoc);
    }

    public static void landClicked(String landLoc, Rectangle rec) {
        Game.landClicked(landLoc, rec);
    }

    public static void townClicked() {
        loadScreen(TOWN);
        Game.changeState(Game.State.IN_TOWN);
    }

}