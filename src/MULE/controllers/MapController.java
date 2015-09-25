package MULE.controllers;

import MULE.models.Game;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ethan on 9/18/2015.
 */
public class MapController implements Initializable {
    //http://stackoverflow.com/questions/27031365/how-to-bind-visibility-to-controller-in-javafx
    BooleanProperty showPass = new SimpleBooleanProperty(false);

    @FXML
    private Rectangle continueRect;

    @FXML
    private Label continueLabel;

    @FXML
    void landClick(MouseEvent event) {
        //System.out.println("Ran the landClick method");
        String landName = ((Node)event.getSource()).getId();
        Rectangle rec = (Rectangle)event.getSource();
        //add in interaction with main here
        //landName will contain a string "RC" containing land's row and column in the set 5x5 array
        ScreenNavigator.instance.landClicked(landName, rec);
        showPass.setValue(ScreenNavigator.instance.showPass.getValue());
    }

    @FXML
    void townClick(MouseEvent event) {
        ScreenNavigator.instance.townClicked();
    }

    @FXML
    void passClick(MouseEvent event) {
        ScreenNavigator.instance.passClick();
        showPass.setValue(ScreenNavigator.instance.showPass.getValue());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        continueRect.visibleProperty().bind(showPass);
        continueLabel.visibleProperty().bind(showPass);
    }
}
