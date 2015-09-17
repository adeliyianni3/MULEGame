package Mule;

import Mule.controllers.ScreensController;
import Mule.models.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Game application class.
 */
public class Game extends Application {

    public static int numOfPlayers = 1;
    public static int playerConfiguration = 0;
    public static Player[] players = new Player[4];
    public static final String MAIN_SCREEN_FXML = "/views/mainScreen.fxml";
    public static final String PLAYER_SCREEN_FXML = "/views/player.fxml";
    public static final String CONGRATULATIONS_SCREEN_FXML = "/views/congratulations.fxml";
    public static final String MAIN_SCREEN = "main";
    public static final String PLAYER_SCREEN = "player";
    public static final String CONGRATULATIONS_SCREEN = "congratulations";

    @Override
    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Game.MAIN_SCREEN,
                Game.MAIN_SCREEN_FXML);
        mainContainer.loadScreen(Game.PLAYER_SCREEN,
                Game.PLAYER_SCREEN_FXML);
        mainContainer.loadScreen(Game.CONGRATULATIONS_SCREEN,
                Game.CONGRATULATIONS_SCREEN_FXML);

        mainContainer.setScreen(Game.MAIN_SCREEN);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        /**
         * Loads the main fxml layout.
         * Sets up the vista switching VistaNavigator.
         * Loads the first vista into the fxml layout.
         *
         * @return the loaded pane.
         * @throws IOException if the pane could not be loaded.
         */
//    private Pane loadMainPane() throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//
//        Pane mainPane = (Pane) loader.load(
//            getClass().getResourceAsStream(
//                ScreenNavigator.MAIN
//            )
//        );
//
//        MainController mainController = loader.getController();
//
//        ScreenNavigator.setMainController(mainController);
//        ScreenNavigator.loadScreen(ScreenNavigator.MAIN_SCREEN);
//
//        return mainPane;
//    }
//
//    /**
//     * Creates the main application scene.
//     *
//     * @param mainPane the main application layout.
//     *
//     * @return the created scene.
//     */
//    private Scene createScene(Pane mainPane) {
//        Scene scene = new Scene(
//            mainPane
//        );
//
//        scene.getStylesheets().setAll(
//            getClass().getResource("vista.css").toExternalForm()
//        );
//
//        return scene;
//    }
//

    public static void main(String[] args) {
        launch(args);
    }
}
