package MULE;

import MULE.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class.
 */
public class Main extends Application {

    private static int totalTurns = 1;
    private static int numOfPlayers = 1;
    protected static int playerConfiguration = 0; //delete this and shove responsibilities into turn
    private static int turn = 1;
    public static State currentState = State.MAIN;

    public enum State{
        MAIN, CONFIG, MAP, TOWN, AUCTION;
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("M.U.L.E.");

        //MouseEvent stuff
        //http://stackoverflow.com/questions/16635514/how-to-get-location-of-mouse-in-javafx
        //https://blog.idrsolutions.com/2013/01/mouseevents-in-javafx/

        stage.setScene(
                createScene(
                        loadMainPane()
                )
        );

        stage.show();
    }

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        ScreenNavigator.MAIN
                )
        );

        MainController mainController = loader.getController();

        ScreenNavigator.setMainController(mainController);
        ScreenNavigator.loadScreen(ScreenNavigator.MAIN_SCREEN);

        return mainPane;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        scene.getStylesheets().setAll(
                getClass().getResource("/vista.css").toExternalForm()
        );

        return scene;
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void actionRelay(String message) {
        //For now we will awkwardly parse messages from the ScreenNavigator here, we'll look into listeners later
        switch(currentState) {
            case MAIN:
                break;
            case CONFIG:
                break;
            case MAP:
                break;
            case TOWN:
                break;
            case AUCTION:
                break;
            default:
                System.out.println("This shouldn't have been possible. Main.actionRelay() error.");
        }
    }

    public static void storeClicked(String storeLoc) {

    }

    public static void landClicked(String landLoc) {

    }

    public static int endTurn() {
        turn = turn + 1 % numOfPlayers + 1;
        totalTurns++;
        return turn;
    }

    public static void incrementTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
    }

    public static int getTotalTurns() {
        return totalTurns;
    }

    public static int getTurn() {
        return turn;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int num) {
        numOfPlayers = num;
    }


}