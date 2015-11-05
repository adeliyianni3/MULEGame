package MULE.controllers;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javafx.fxml.FXMLLoader;

import java.io.*;


import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class ScreenNavigator {

    public final BooleanProperty showPass = new SimpleBooleanProperty(false);
    public boolean loaded = false;

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public final String MAIN_SCREEN = "/views/mainScreen.fxml";
    private final String PLAYER = "/views/player.fxml";
    private final String CONGRATULATIONS = "/views/congratulations.fxml";
    public final String MAIN = "/views/main.fxml";
    private final String MAP = "/views/map.fxml";
    private final String TOWN = "/views/town.fxml";
    private final String STORE = "/views/store.fxml";
    private final String MULE_PEN = "/views/mulePen.fxml";
    private final String ERROR = "/views/Error_Screen.fxml";

    public Scene mainScreen;
    private Scene playerScreen;
    private Scene congratulations;
    public Scene main;
    private Scene map;
    private Scene town;
    private Scene store;
    private Scene mulePen;
    private Scene errorMessage;

    public static final ScreenNavigator instance = new ScreenNavigator();
    private Stage stage;

    /** The main application layout controller. */
    private static MainController mainController;

    private ScreenNavigator() {
        Parent root;
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
            root = FXMLLoader.load(getClass().getResource(ERROR));
            errorMessage = new Scene(root);
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
    private void loadScreen(String fxml) {

        switch (fxml) {
            case MAIN_SCREEN: loadScreen(mainScreen);
                break;
            case PLAYER: loadScreen(playerScreen);
                break;
            case CONGRATULATIONS: loadScreen(congratulations);
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
            case ERROR: loadScreen(errorMessage);
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
        Game.instance.changeState(Game.State.MAIN);
    }
    public void loadTown() {
        loadScreen(TOWN);
    }

    public void loadMap() {
        loadScreen(MAP);
    }
    public void loadMULEPen() {
        loadScreen(MULE_PEN);
    }

    public void loadErrorMessage() {
        loadScreen(ERROR);
    }

    public void loadPlayer() {
        loadScreen(PLAYER);
    }
    public void loadStore() {
        loadScreen(STORE);
    }
    public void loadEndGame() {
        loadScreen(CONGRATULATIONS);
    }

    public void loadNewPlayer() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(PLAYER));
            playerScreen = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadScreen(PLAYER);
    }

    public void togglePassButton() {
        showPass.setValue(!showPass.getValue());
    }

    public void loadLoadedMap() {
        loaded = true;
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getResource(MAP));
            //MapController mapController = fxmlLoader.getController(); //can't close game without
            map = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loaded = false;
    }

}