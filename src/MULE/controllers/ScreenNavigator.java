package MULE.controllers;

import MULE.models.Game;
import MULE.Main;
import MULE.models.Resource;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class ScreenNavigator {

    public BooleanProperty showPass = new SimpleBooleanProperty(false);

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public final String MAIN_SCREEN = "/views/mainScreen.fxml";
    public final String PLAYER = "/views/player.fxml";
    public final String CONGRATULATIONS = "/views/congratulations.fxml";
    public final String MAIN = "/views/main.fxml";
    public final String MAP = "/views/map.fxml";
    public final String TOWN = "/views/town.fxml";
    public final String STORE = "/views/store.fxml";
    public final String MULE_PEN = "/views/mulePen.fxml";

    public Scene mainScreen;
    public Scene playerScreen;
    public Scene congratulations;
    public Scene main;
    public Scene map;
    public Scene town;
    public Scene store;
    public Scene mulePen;

    public String currentState;



    public static ScreenNavigator instance = new ScreenNavigator();
    private Stage stage;

    /** The main application layout controller. */
    private static MainController mainController;

    private ScreenNavigator() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(MAIN_SCREEN));
            mainScreen = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(PLAYER));
            playerScreen = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(CONGRATULATIONS));
            congratulations = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(MAIN));
            main = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(MAP));
            map = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(TOWN));
            town = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(STORE));
            store = new Scene(root);
            root = FXMLLoader.load(getClass().getResource(MULE_PEN));
            mulePen = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public void setMainController(MainController mainController) {
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
    public void loadScreen(String fxml) {
//        try {
//            mainController.setVista( //this clears the pane and fills it with the fxml
//                    (Node) FXMLLoader.load(
//                            ScreenNavigator.class.getResource(
//                                    fxml
//                            )
//                    )
//            );
//        } catch (IOException e) {
//            System.out.println("Could not find file");
//            //e.printStackTrace();
//        }
        //out with the old and in with the new
        switch (fxml) {
            case MAIN_SCREEN: loadScreen(mainScreen);
                break;
            case PLAYER: loadScreen(playerScreen);
                break;
            case CONGRATULATIONS: loadScreen(main);
                break;
            case MAIN: loadScreen(main);
                break;
            case MAP: loadScreen(map);
                break;
            case TOWN: loadScreen(town);
                break;
            case STORE: loadScreen(store);
                break;
            case MULE_PEN: loadScreen(mulePen);
                break;
            default: System.out.println("Something went horribly wrong: ScreenNavigator.loadScreen(String)");
                break;
        }
    }

    public void loadScreen(Scene scene) {
        stage.setScene(scene);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loadMain() {
        loadScreen(MAIN_SCREEN);
        Game.changeState(Game.State.MAIN);
    }
    public void loadTown() {
        loadScreen(TOWN);
        Game.changeState(Game.State.IN_TOWN);
    }

    public void loadCongratulations() {
        loadScreen(CONGRATULATIONS);
    }


    public void loadPlayerConfiguration() {
        Game.changeState(Game.State.CONFIG);
        //System.out.println(Main.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        loadScreen(PLAYER);
        Game.incrementTurn();
    }

    //TODO used to fix the turn order issue at the start of the game, fix other code before implementing
    public void loadPlayerConfigurationFromMain() {
        Game.changeState(Game.State.CONFIG);
        //System.out.println(Main.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        loadScreen(PLAYER);
    }

    public void loadPlayerConfiguration(String race, Color c, String name) { //parameters have been made obsolete, change name later or redo
        System.out.println(Game.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        if (Game.getNumOfPlayers() >= Game.getTurn() && Game.getTotalTurns() == Game.getTurn()) {

            //http://stackoverflow.com/questions/26899197/how-can-a-textfield-from-fxml-file-be-updated-by-settext-in-java-file
//            playerNumber.setText("Player " + Main.playerConfiguration);
//            playerNumber.textProperty().set("Player " + Main.playerConfiguration);
            try {
                Parent root = FXMLLoader.load(getClass().getResource(PLAYER));
                playerScreen = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }

            loadScreen(PLAYER);

        } else {
            loadScreen(MAP);
            Game.changeState(Game.State.BUYPHASE);
        }

        Game.incrementTurn();
    }
    public void loadMap() {
        loadScreen(MAP);

    }
    public void loadMULEPen() {
        loadScreen(MULE_PEN);
    }
    public void loadStore() {
        loadScreen(STORE);
    }
    public void setLandColor(String loc, Color c) {

    }

    public void buyMULE(Resource resource) {
        Game.buyMULE(resource);
    }

//    public void landClicked(String landLoc) {
//        Game.landClicked(landLoc);
//    }

    public void passClick() {
        Game.buyPhaseSkip();
    }

    public void landClicked(String landLoc, Rectangle rec, Rectangle mul) {
        Game.landClicked(landLoc, rec, mul);
    }

    public void townClicked() {
        if (Game.currentState == Game.State.MAP) {
            loadScreen(TOWN);
            Game.changeState(Game.State.IN_TOWN);
        }
    }
    public void enterStore() {
        if (Game.currentState == Game.State.IN_TOWN) {
            loadScreen(STORE);
            Game.changeState(Game.State.STORE);
        }
    }

    public void togglePassButton() {
        showPass.setValue(!showPass.getValue());
    }


}