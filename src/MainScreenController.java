import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 * Created by Ethan on 9/10/2015.
 */
public class MainScreenController {


    @FXML
    private ChoiceBox difficultyChoiceBox;
    @FXML
    private ChoiceBox mapChoiceBox;
    @FXML
    private ChoiceBox playerChoiceBox;

    @FXML
    void setUpChoiceBoxes() {
        difficultyChoiceBox.setValue("Easy");
        mapChoiceBox.setValue("Map 1");
        playerChoiceBox.setValue("1");
    }

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    @FXML
    void playerConfiguration(ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.PLAYER);
    }

}
