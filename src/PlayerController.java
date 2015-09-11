import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by Ethan on 9/10/2015.
 */
public class PlayerController {

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    @FXML
    public void toMain(ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.MAIN_SCREEN);
    }

    @FXML
    public void toCongratulations(ActionEvent event) { ScreenNavigator.loadScreen(ScreenNavigator.CONGRATULATIONS); }
}
