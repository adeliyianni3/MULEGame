import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;

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
    public static final String MAIN_SCREEN = "mainScreen.fxml";
    public static final String PLAYER = "player.fxml";
    public static final String PLAYER2 = "player2.fxml";
    public static final String PLAYER3 = "player3.fxml";
    public static final String PLAYER4 = "player4.fxml";
    public static final String CONGRATULATIONS = "congratulations.fxml";
    public static final String MAIN = "main.fxml";
    public static final String MAP = "map.fxml";

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



    public static void loadMap() {
        loadScreen(MAP);
    }

    public static void loadMain() {

    }

    public static void loadCongratulations() {

    }

    public static void loadPlayerConfiguration(int i) {
        switch (i) {
            case 2:
                loadScreen(PLAYER2);
                break;
            case 3:
                loadScreen(PLAYER3);
                break;
            case 4:
                loadScreen(PLAYER4);
                break;
            default:
                loadScreen(CONGRATULATIONS);
                break;
        }
    }

    public static void loadPlayerConfiguration() {
        //System.out.println(Main.getNumOfPlayers() + ": " + Main.getTurn() + ": " + Main.getTotalTurns());
        if (Main.getNumOfPlayers() >= Main.getTurn() && Main.getTotalTurns() == Main.getTurn()) {

            //http://stackoverflow.com/questions/26899197/how-can-a-textfield-from-fxml-file-be-updated-by-settext-in-java-file
//            playerNumber.setText("Player " + Main.playerConfiguration);
//            playerNumber.textProperty().set("Player " + Main.playerConfiguration);
            switch (Main.getTurn()) {
                case 1:
                    loadScreen(PLAYER);
                    break;
                case 2:
                    loadScreen(PLAYER2);
                    break;
                case 3:
                    loadScreen(PLAYER3);
                    break;
                case 4:
                    loadScreen(PLAYER4);
                    break;
                default:
                    loadScreen(CONGRATULATIONS); //replace with something meaningful later
                    break;
            }


        } else {
            loadScreen(MAP);
        }

        Main.incrementTurn();
    }



}