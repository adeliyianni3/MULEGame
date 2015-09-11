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

    protected static int numOfPlayers = 1;
    protected static int playerConfiguration = 1;

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("M.U.L.E.");

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
            getClass().getResource("vista.css").toExternalForm()
        );

        return scene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
