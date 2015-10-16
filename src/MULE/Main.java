package MULE;

import MULE.controllers.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

//trying to set up debug
import java.io.IOException;
import java.net.URL;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class.
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("M.U.L.E.");
        ScreenNavigator.instance.setStage(stage);
        ScreenNavigator.instance.loadScreen(ScreenNavigator.instance.mainScreen);
        //MouseEvent stuff
        //http://stackoverflow.com/questions/16635514/how-to-get-location-of-mouse-in-javafx
        //https://blog.idrsolutions.com/2013/01/mouseevents-in-javafx/

//        stage.setScene(
//                createScene(
//                        loadMainPane()
//                )
//        );

        Stage debugStage = new Stage();
        debugStage.setTitle("Game Information");
//        String OUTSIDE_TEXT = "Outside Label";
//        final Label reporter = new Label(OUTSIDE_TEXT);
//        Label monitored = createMonitoredLabel(reporter);
//
//        VBox layout = new VBox(10);
//        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10px;");
//        layout.getChildren().setAll(
//                monitored,
//                reporter
//        );
//        layout.setPrefWidth(500);

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

        URL resource = getClass().getResource("/audio/Edward_Shallow_-_02_-_Merchant.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Game.setMediaPlayer(mediaPlayer);
        Game.playMusic();

        debugStage.show();

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
                        ScreenNavigator.instance.MAIN
                )
        );

        MainController mainController = loader.getController();

        ScreenNavigator.instance.setMainController(mainController);
        ScreenNavigator.instance.loadScreen(ScreenNavigator.instance.main);

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


    private Label createMonitoredLabel(final Label reporter) {
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
    }

}