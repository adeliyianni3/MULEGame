package MULE.controllers;

import MULE.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

// Created by Antonia on 9/26/2015.
public class StoreController implements Initializable {
    private final ObservableList<Resource> items = FXCollections.observableArrayList();
    @FXML
    private ListView<Resource> cartList;

    public void leaveStore() {
        Game.getInstance().leaveStore();
        cartList.getItems().clear();
        ScreenNavigator.getInstance().loadTown();
    }

    @FXML
    private void handleLoadGame() {
        Game.getInstance().loadGame();
    }
    @FXML
    private void handleSaveGame() {
        Game.getInstance().saveGame();
    }


    @FXML
    public void addCartFood() {
        items.add(new Food());
    }
    @FXML
    public void addCartEnergy() {
        items.add(new Energy());
    }
    @FXML
    public void addCartSmithore() {
        items.add(new SmithOre());
    }
    @FXML
    public void addCartCrystite() {
        items.add(new Crystite());
    }
    @FXML
    public void addCartLumber() {
        items.add(new Lumber());
    }
    @FXML
    public void buySilo() {
        Player p = Game.getInstance().getPlayers()[Game.getInstance().getTurn() - 1];
        p.addSilo();
    }
    @FXML
    public void purchaseCart() {
        Player p = Game.getInstance().getPlayers()[Game.getInstance().getTurn() - 1];
        Object[] stuff = items.toArray();
        for (Object thing: stuff) {
            Resource item = (Resource) thing;
            int price = item.getPrice();
            if (p.getMoney() < price){
                System.out.println("You do not have enough money.\nUnit price: " + price + ", Your money: " + p.getMoney());
            } else {
                if (p.siloHasSpace(item)) {
                    if (item.getInventory(Game.getInstance().getStore()) > 0) {
                        p.subtractMoney(price);
                        p.addResource(item);
                        System.out.println(item.buyInventory(Game.getInstance().getStore()) + " " + thing.toString() + " left");
                        cartList.getItems().remove(thing);
                    }
                }
            }
        }
        System.out.println(p.getMoney());
    }
    @FXML
    private void pauseMusic() {
        Game.getInstance().pauseMusic();
    }
    @FXML
    private void playMusic() {
        Game.getInstance().playMusic();
    }
    @FXML
    private void closeGame() {
        Game.getInstance().timer.stopTime();
        System.exit(0);
    }

    @FXML
    public void sellItems() {
        Player p = Game.getInstance().getPlayers()[Game.getInstance().getTurn() - 1];
        Object[] cartStuff = items.toArray();
        for (Object item: cartStuff) {
            Resource item2 = (Resource) item;
            if (p.contains(item2)){
                p.removeResource(item2);
                item2.sellInventory(Game.getInstance().getStore());
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
        ScreenNavigator.getInstance().loadMain();
    }

    @FXML void toMULEPen() {
        ScreenNavigator.getInstance().loadMULEPen();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartList.setItems(items);
    }


}
