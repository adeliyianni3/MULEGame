import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Ethan on 9/10/2015.
 */
public class PlayerController {

    @FXML
    private Label playerNumber;

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */

    @FXML
    void toMain(ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.MAIN_SCREEN);
    }

    @FXML
    void toNext(ActionEvent event) {
        if (Main.numOfPlayers > Main.playerConfiguration) {
            //System.out.println(Main.playerConfiguration + "of" + Main.numOfPlayers);
            Main.playerConfiguration++;
            //playerNumber.setText("Player " + Main.playerConfiguration);
            playerNumber.textProperty().set("Player " + Main.playerConfiguration);
            switch (Main.playerConfiguration) {
                case 2:
                    ScreenNavigator.loadScreen(ScreenNavigator.PLAYER2);
                    break;
                case 3:
                    ScreenNavigator.loadScreen(ScreenNavigator.PLAYER3);
                    break;
                case 4:
                    ScreenNavigator.loadScreen(ScreenNavigator.PLAYER4);
                    break;
                default:
                    ScreenNavigator.loadScreen(ScreenNavigator.CONGRATULATIONS);
                    break;
            }
        } else {
            ScreenNavigator.loadScreen(ScreenNavigator.CONGRATULATIONS);
        }
    }
}
