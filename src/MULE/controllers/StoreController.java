package MULE.controllers;

import MULE.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

// Created by Antonia on 9/26/2015.
public class StoreController implements Initializable {
    private final ObservableList<Resource> items = FXCollections.observableArrayList();
    @FXML
    private ListView<Resource> cartList;

    public void leaveStore(MouseEvent event) {
        String side = ((Node)event.getSource()).getId();
        Game.instance.leaveStore(side);
        cartList.getItems().clear();
        ScreenNavigator.instance.loadTown();
    }

    @FXML
    private void handleLoadGame(ActionEvent e) {
        Game.instance.loadGame();
    }
    @FXML
    private void handleSaveGame(ActionEvent e) {
        Game.instance.saveGame();
    }


    @FXML
    public void addCartFood(MouseEvent event) {
        items.add(new Food());
    }
    @FXML
    public void addCartEnergy(MouseEvent event) {
        items.add(new Energy());
    }
    @FXML
    public void addCartSmithore(MouseEvent event) {
        items.add(new SmithOre());
    }
    @FXML
    public void addCartCrystite(MouseEvent event) {
        items.add(new Crystite());
    }
    @FXML
    public void purchaseCart() {
        Player p = Game.instance.getPlayers()[Game.instance.getTurn() - 1];
        Object[] stuff = items.toArray();
        for (Object thing: stuff) {
            Resource item = (Resource) thing;
            int price = item.getPrice();
            if (p.getMoney() < price){
                System.out.println("You do not have enough money.\nUnit price: " + price + ", Your money: " + p.getMoney());
            } else {
                if (item.getInventory(Game.instance.getStore()) > 0) {
                    p.subtractMoney(price);
                    p.addResource(item);
                    System.out.println(item.buyInventory(Game.instance.getStore()) + " " + thing.toString() + " left");
                    cartList.getItems().remove(thing);
                }
            }
        }
        System.out.println(p.getMoney());
    }
    @FXML
    private void pauseMusic(ActionEvent e) {
        Game.instance.pauseMusic();
    }
    @FXML
    private void playMusic(ActionEvent e) {
        Game.instance.playMusic();
    }
    @FXML
    private void closeGame(ActionEvent e) {
        Game.instance.timer.stopTime();
        System.exit(0);
    }

    @FXML
    public void sellItems() {
        Player p = Game.instance.getPlayers()[Game.instance.getTurn() - 1];
        Object[] cartStuff = items.toArray();
        for (Object item: cartStuff) {
            Resource item2 = (Resource) item;
            if (p.contains(item2)){
                p.removeResource(item2);
                item2.sellInventory(Game.instance.getStore());
                p.addMoney(item2.getPrice());
                cartList.getItems().remove(item);
                System.out.println("Congratz Y'all! Just sold " + item);
            } else {
                System.out.println("Sold Nothing");
            }
        }
    }
    @FXML
    public void removeItem() {
        int selected = cartList.getSelectionModel().getSelectedIndex();
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
