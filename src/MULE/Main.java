package MULE;

import MULE.controllers.*;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;

/**
 * Main application class.
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("M.U.L.E.");
        ScreenNavigator.getInstance().setStage(stage);
        ScreenNavigator.getInstance().loadScreen(ScreenNavigator.getInstance().getMainScreen());

        Stage debugStage = new Stage();
        debugStage.setTitle("Game Information");

        Scene debugScene = null;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/debug.fxml"));
            debugScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        debugStage.setScene(
                debugScene
        );

        URL resource = Game.instance.getSongFile();
        makeMusic(resource);

        debugStage.show();

        stage.show();
    }

    public static void makeMusic(URL resource) {
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Game.instance.setMediaPlayer(mediaPlayer);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        Game.instance.playMusic();
    }
    /*/**
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
//        Pane mainPane = loader.load(
//                getClass().getResourceAsStream(
//                        ScreenNavigator.instance.MAIN
//                )
//        );
//
//        MainController mainController = loader.getController();
//
//        ScreenNavigator.instance.setMainController(mainController);
//        ScreenNavigator.instance.loadScreen(ScreenNavigator.instance.main);
//
//        return mainPane;
//    }

    /*/**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    /*private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        scene.getStylesheets().setAll(
                getClass().getResource("/vista.css").toExternalForm()
        );

        return scene;
    }*/


    public static void main(String[] args) {
        launch(args);
    }


    /*private Label createMonitoredLabel(final Label reporter) {
        final Label monitored = new Label("Mouse Location Monitor");

        monitored.setStyle("-fx-background-color: forestgreen; -fx-text-fill: white; -fx-font-size: 20px;");

        monitored.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                String msg =
                        "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
                                "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
                                "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";

                reporter.setText(msg);
            }
        });

        monitored.setOnMouseExited(new EventHandler<MouseEvent>() {
            String OUTSIDE_TEXT = "Outside Label";
            @Override
            public void handle(MouseEvent event) {
                reporter.setText(OUTSIDE_TEXT);
            }
        });

        return monitored;
    }*/

}