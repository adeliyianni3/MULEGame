package MULE.controllers;

import MULE.models.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Antonia on 9/26/2015.
 */
public class StoreController implements Initializable {
    private ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private ListView<String> cartList;

    public void leaveStore(MouseEvent event) {
        String side = ((Node)event.getSource()).getId();
        Game.leaveStore(side);
        cartList.getItems().clear();
        ScreenNavigator.instance.loadTown();
    }
    public void addCart(MouseEvent event) {
        String side = ((Node) event.getSource()).getId();
        items.add(side);

    }
    @FXML
    public void purchaseCart() {
        Game.purchaseCart(items, cartList);
    }

    public void showMap() {
        ScreenNavigator.instance.loadMain();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartList.setItems(items);
    }
}
