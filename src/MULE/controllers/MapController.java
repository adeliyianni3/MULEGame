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
    private Rectangle map00;
    @FXML
    private Rectangle map01;
    @FXML
    private Rectangle map02;
    @FXML
    private Rectangle map03;
    @FXML
    private Rectangle map04;
    @FXML
    private Rectangle map05;
    @FXML
    private Rectangle map06;
    @FXML
    private Rectangle map07;
    @FXML
    private Rectangle map08;
    @FXML
    private Rectangle map10;
    @FXML
    private Rectangle map11;
    @FXML
    private Rectangle map12;
    @FXML
    private Rectangle map13;
    @FXML
    private Rectangle map14;
    @FXML
    private Rectangle map15;
    @FXML
    private Rectangle map16;
    @FXML
    private Rectangle map17;
    @FXML
    private Rectangle map18;
    @FXML
    private Rectangle map20;
    @FXML
    private Rectangle map21;
    @FXML
    private Rectangle map22;
    @FXML
    private Rectangle map23;
    @FXML
    private Rectangle map24;
    @FXML
    private Rectangle map25;
    @FXML
    private Rectangle map26;
    @FXML
    private Rectangle map27;
    @FXML
    private Rectangle map28;
    @FXML
    private Rectangle map30;
    @FXML
    private Rectangle map31;
    @FXML
    private Rectangle map32;
    @FXML
    private Rectangle map33;
    @FXML
    private Rectangle map34;
    @FXML
    private Rectangle map35;
    @FXML
    private Rectangle map36;
    @FXML
    private Rectangle map37;
    @FXML
    private Rectangle map38;
    @FXML
    private Rectangle map40;
    @FXML
    private Rectangle map41;
    @FXML
    private Rectangle map42;
    @FXML
    private Rectangle map43;
    @FXML
    private Rectangle map44;
    @FXML
    private Rectangle map45;
    @FXML
    private Rectangle map46;
    @FXML
    private Rectangle map47;
    @FXML
    private Rectangle map48;

    @FXML
    private Rectangle mul00;
    @FXML
    private Rectangle mul01;
    @FXML
    private Rectangle mul02;
    @FXML
    private Rectangle mul03;
    @FXML
    private Rectangle mul04;
    @FXML
    private Rectangle mul05;
    @FXML
    private Rectangle mul06;
    @FXML
    private Rectangle mul07;
    @FXML
    private Rectangle mul08;
    @FXML
    private Rectangle mul10;
    @FXML
    private Rectangle mul11;
    @FXML
    private Rectangle mul12;
    @FXML
    private Rectangle mul13;
    @FXML
    private Rectangle mul14;
    @FXML
    private Rectangle mul15;
    @FXML
    private Rectangle mul16;
    @FXML
    private Rectangle mul17;
    @FXML
    private Rectangle mul18;
    @FXML
    private Rectangle mul20;
    @FXML
    private Rectangle mul21;
    @FXML
    private Rectangle mul22;
    @FXML
    private Rectangle mul23;
    @FXML
    private Rectangle mul24;
    @FXML
    private Rectangle mul25;
    @FXML
    private Rectangle mul26;
    @FXML
    private Rectangle mul27;
    @FXML
    private Rectangle mul28;
    @FXML
    private Rectangle mul30;
    @FXML
    private Rectangle mul31;
    @FXML
    private Rectangle mul32;
    @FXML
    private Rectangle mul33;
    @FXML
    private Rectangle mul34;
    @FXML
    private Rectangle mul35;
    @FXML
    private Rectangle mul36;
    @FXML
    private Rectangle mul37;
    @FXML
    private Rectangle mul38;
    @FXML
    private Rectangle mul40;
    @FXML
    private Rectangle mul41;
    @FXML
    private Rectangle mul42;
    @FXML
    private Rectangle mul43;
    @FXML
    private Rectangle mul44;
    @FXML
    private Rectangle mul45;
    @FXML
    private Rectangle mul46;
    @FXML
    private Rectangle mul47;
    @FXML
    private Rectangle mul48;

    private Rectangle[][] mapArr;


    private Rectangle[][] mulArr;

    @FXML
    private Rectangle continueRect;

    @FXML
    private Label continueLabel;

    @FXML
    void landClick(MouseEvent event) {
        //System.out.println("Ran the landClick method");
        String landName = ((Node)event.getSource()).getId();
        Rectangle rec = (Rectangle)event.getSource();
        int i = Integer.parseInt(landName.substring(3, 5)) / 10;
        int j = Integer.parseInt(landName.substring(3, 5)) % 10;
        if (mapArr[i][j] == null) {
            System.out.println("mapArr was null");
        }
        if (mulArr[i][j] == null) {
            System.out.println("mulArr was null");
        }
        //add in interaction with main here
        //landName will contain a string "RC" containing land's row and column in the set 5x5 array
        ScreenNavigator.instance.landClicked(landName, mapArr[i][j], mulArr[i][j]);
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

    public void setArrs() {
        Rectangle[][] tempArr = {{map00, map01, map02, map03, map04, map05, map06, map07, map08}, {map10, map11, map12, map13, map14, map15, map16, map17, map18}, {map20, map21, map22, map23, map24, map25, map26, map27, map28}, {map30, map31, map32, map33, map34, map35, map36, map37, map38}, {map40, map41, map42, map43, map44, map45, map46, map47, map48}};
        mapArr = tempArr;
        Rectangle[][] tempArr2 = {{mul00, mul01, mul02, mul03, mul04, mul05, mul06, mul07, mul08}, {mul10, mul11, mul12, mul13, mul14, mul15, mul16, mul17, mul18}, {mul20, mul21, mul22, mul23, mul24, mul25, mul26, mul27, mul28}, {mul30, mul31, mul32, mul33, mul34, mul35, mul36, mul37, mul38}, {mul40, mul41, mul42, mul43, mul44, mul45, mul46, mul47, mul48} };
        mulArr = tempArr2;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        continueRect.visibleProperty().bind(showPass);
        continueLabel.visibleProperty().bind(showPass);
        setArrs();
    }
}
