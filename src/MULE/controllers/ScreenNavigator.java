package MULE.controllers;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javafx.fxml.FXMLLoader;

import java.io.IOException;


import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public final class ScreenNavigator {

    /**
     * Boolean property representing whether or not the pass button is showing.
     */
    private final BooleanProperty showPass = new SimpleBooleanProperty(false);

    /**
     * Determines whether or not the saved instance is being loaded.
     */
    private boolean loaded = false;

    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String MAIN_SCREEN = "/views/mainScreen.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String PLAYER = "/views/player.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String CONGRATULATIONS = "/views/congratulations.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String MAIN = "/views/main.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String MAP = "/views/map.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String TOWN = "/views/town.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String STORE = "/views/store.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String MULE_PEN = "/views/mulePen.fxml";
    /**
     * Convenience constant for fxml layouts managed by the navigator.
     */
    private static final String ERROR = "/views/Error_Screen.fxml";

    /**
     * Saved Scene for screen.
     */
    private Scene mainScreen;
    /**
     * Saved Scene for screen.
     */
    private Scene playerScreen;
    /**
     * Saved Scene for screen.
     */
    private Scene congratulations;
    /**
     * Saved Scene for screen.
     */
    private Scene main;
    /**
     * Saved Scene for screen.
     */
    private Scene map;
    /**
     * Saved Scene for screen.
     */
    private Scene town;
    /**
     * Saved Scene for screen.
     */
    private Scene store;
    /**
     * Saved Scene for screen.
     */
    private Scene mulePen;
    /**
     * Saved Scene for screen.
     */
    private Scene errorMessage;

    /**
     * Current instance of the ScreenNavigator.
     */
    private static ScreenNavigator instance = new ScreenNavigator();
    /**
     * Stage being used to set Scenes on.
     */
    private Stage stage;
    /**
     * Gets the instance.
     * @return The instance
     */
    public static ScreenNavigator getInstance() {
        return instance;
    }
    /** The main application layout controller. */
//    private static MainController mainController;

    /**
     * No-args constructor.
     */
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
     * Gets whether or not the ScreenNavigator is being loaded.
     * @return Whether or not the ScreenNavigator is being loaded
     */
    public boolean getLoaded() {
        return loaded;
    }
    /**
     * Gets the BooleanProperty showPass.
     * @return The boolean property showPass
     */
    public BooleanProperty getShowPass() {
        return showPass;
    }

    /**
     * Gets the scene of the main screen.
     * @return The scene of the main screen
     */
    public Scene getMainScreen() {
        return mainScreen;
    }

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
//    public void setMainController(MainController mainController) {
//        ScreenNavigator.mainController = mainController;
//    }

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
    private void loadScreen(final String fxml) {

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
            default: System.out.println("Something went horribly wrong: "
                    + "ScreenNavigator.loadScreen(String)");
                break;
        }
    }

    /**
     * Loads the given scene to the stage.
     * @param scene Scene to be set to stage
     */
    public void loadScreen(final Scene scene) {
        stage.setScene(scene);
    }

    /**
     * Sets the held stage.
     * @param newStage Stage to be set
     */
    public void setStage(final Stage newStage) {
        stage = newStage;
    }

    /**
     * Loads the main screen.
     */
    public void loadMain() {
        loadScreen(MAIN_SCREEN);
        Game.getInstance().changeState(Game.State.MAIN);
    }
    /**
     * Loads the town.
     */
    public void loadTown() {
        loadScreen(TOWN);
    }

    /**
     * Loads the map.
     */
    public void loadMap() {
        loadScreen(MAP);
    }
    /**
     * Loads the mule pen.
     */
    public void loadMULEPen() {
        loadScreen(MULE_PEN);
    }

    /**
     * Loads an error message.
     */
    public void loadErrorMessage() {
        loadScreen(ERROR);
    }

    /**
     * Loads the player configuration screen.
     */
    public void loadPlayer() {
        loadScreen(PLAYER);
    }
    /**
     * Loads the store.
     */
    public void loadStore() {
        loadScreen(STORE);
    }
    /**
     * Loads the congratulations screen.
     */
    public void loadEndGame() {
        loadScreen(CONGRATULATIONS);
    }

    /**
     * Loads a new player configuration screen.
     */
    public void loadNewPlayer() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(PLAYER));
            playerScreen = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadScreen(PLAYER);
    }

    /**
     * Toggles the showPass value.
     */
    public void togglePassButton() {
        showPass.setValue(!showPass.getValue());
    }

    /**
     * Loads a saved map when loading a game.
     */
    public void loadLoadedMap() {
        loaded = true;
        try {
            Parent root = FXMLLoader.load(getClass().getResource(MAP));
            map = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loaded = false;
    }

}
