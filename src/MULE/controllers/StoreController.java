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
    private int selected;

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
    public void addCartFood(MouseEvent event) {
        items.add("food");
    }
    @FXML
    public void addCartEnergy(MouseEvent event) {
        items.add("energy");
    }
    @FXML
    public void addCartSmithore(MouseEvent event) {
        items.add("smith_ore");
    }
    @FXML
    public void addCartCrystite(MouseEvent event) {
        items.add("crystite");
    }
    @FXML
    public void purchaseCart() {
        Game.purchaseCart(items, cartList);
    }

    @FXML
    public void sellItems() {
        Game.sellItems(items, cartList);
    }
    @FXML
    public void removeItem() {
        selected = cartList.getSelectionModel().getSelectedIndex();
        if (selected != -1) {
            cartList.getItems().remove(selected);
        }
    }

    public void showMap() {
        ScreenNavigator.instance.loadMain();
    }

    @FXML void toMULEPen() {
        ScreenNavigator.instance.loadMULEPen();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartList.setItems(items);
    }
}
