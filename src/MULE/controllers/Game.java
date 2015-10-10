package MULE.controllers;


import MULE.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



//Created by Aaron on 9/17/2015.
public class Game {
    private static ArrayList<Color> notAllowed = new ArrayList<Color>(Arrays.asList(Color.WHITE));
    public static int numOfPlayers = 1;
    public static final int DEFAULT_PLAYER_AMOUNT = 0; //why is this 0?
    public static int round = 0;
    public static Player[] players = new Player[DEFAULT_PLAYER_AMOUNT];
    public static Player[] originalPlayers = new Player[DEFAULT_PLAYER_AMOUNT];
    private static int difficulty;
    private static int mapType;
    private static int[] playerTurn; //unused?
    private static int totalTurns = 1;
    private static int turn = 1;
    public static State currentState = State.MAIN;
    public static PlayerTimer timer = new PlayerTimer();
    public static ResourceStore store = new ResourceStore();
    public static int[] resourcePoints = {1, 500, 1, 1, 1}; //holds point values of money, land, energy, smithore, food

    private static MediaPlayer mediaPlayer = null;

    private static Map theMap = new Map();
    private static int buyPhaseSkipped = 0;
    
    public static int LAND_PRICE = 300;


    public static void leaveTown(String side) {
        currentState = State.MAP;
    }

    //TODO for animations later
    public static void leaveStore(String side) {


    }


    public enum State{
        MAIN, CONFIG, IN_TOWN, AUCTION, BUYPHASE, MAP, STORE, MULE_PLACING
    }

    public static void setMediaPlayer(MediaPlayer mp) {
        mediaPlayer = mp;
    }

    public static void playMusic() {
        mediaPlayer.play();
    }

    public static void pauseMusic() {
        mediaPlayer.pause();
    }

    public static void changeState(State s) {
        currentState = s;
    }

    public static int getDifficulty() {
        return difficulty;
    }


    public static int getMapType() {
        return mapType;
    }

    public static void setMapType(int mapType) {
        Game.mapType = mapType;
    }

    public static void setNumOfPlayers(int num) {
        numOfPlayers = num;
        players = new Player[num];
        originalPlayers = new Player[num];
        playerTurn = new int[num];
        for (int i = 0; i < num; i++) {
            playerTurn[i] = i + 1;
        }
    }

    public static ArrayList<Color> getColors() {
        return notAllowed;
    }

    public static boolean isColorAvailable(Color c) {
        return !notAllowed.contains(c);
    }

    public static void useAssay() {

    }

    public static void useLandOffice() {

    }

    public static int getRound() {
        return round;
    }

    public static State getPhase() {
        return currentState;
    }

    public static Player[] getPlayers() {
        return players;
    }
    public static Player[] getOriginalPlayers() {
        return originalPlayers;
    }

    public static void gamble() {
        int[] roundBonus = {50,50,50,100,100,100,100,150,150,150,150,200};
        int timeBonus;
        int bonus;
        Random rand = new Random();
        int time = timer.getTime();
        System.out.println(time);
        if (time<=12){
            timeBonus=50;
        } else if (time<=25){
            timeBonus=100;
        } else if (time<=37){
            timeBonus=150;
        } else{
            timeBonus=200;
        }
        bonus = roundBonus[round-1]+rand.nextInt(timeBonus + 1);
        if (bonus>250){
            bonus=250;
        }
        players[turn-1].addMoney(bonus);
        System.out.println("Gambled and won " + bonus + ".");
        timer.stopTime();
    }

    public static void buyPhaseSkip() {
        System.out.println("buyPhaseSkip() called.");
        if (currentState.equals(State.BUYPHASE)) {
            System.out.println("buyPhaseSkip() executed.");
            buyPhaseSkipped++;
            buyPhaseEndTurn();
        }
    }

    public static Player currentPlayer() {
        return players[getTurn() - 1];
    }
    public static void landClicked(String landLoc, Rectangle rec, Rectangle mul) {
        if (currentState.equals(State.BUYPHASE)) {
            System.out.println("Round:" + round);
            int i = Integer.parseInt(landLoc.substring(3, 5)) / 10;
            int j = Integer.parseInt(landLoc.substring(3, 5)) % 10;
            System.out.println(i + ", " + j);
            Land plot = theMap.whatLand(i, j);
            System.out.println("Turn: " + turn + ", Total Turns: " + totalTurns);
            if (!plot.isOwned()) {
                Player p = players[turn - 1];
                if (round < 3) {
                    plot.setOwner(p);
                    p.addLand(plot);
                    rec.setStroke(p.getColor());
                    rec.setStrokeWidth(8.0);
                    p.incrementLand();
                    buyPhaseSkipped = 0;
                    buyPhaseEndTurn();
                } else {
                    if (p.getMoney() >= LAND_PRICE) {
                        plot.setOwner(p);
                        p.addLand(plot);
                        rec.setStroke(p.getColor());
                        rec.setStrokeWidth(8.0);
                        p.subtractMoney(LAND_PRICE);
                        p.incrementLand();
                        buyPhaseSkipped = 0;
                        buyPhaseEndTurn();
                    }
                }
            }
            if (round == 3 && turn == 1) {
                ScreenNavigator.instance.togglePassButton();
            }


            System.out.println(playersToString()); //debug statement
        } else if (currentState.equals(State.MULE_PLACING)) {
            int i = Integer.parseInt(landLoc.substring(3, 5)) / 10;
            int j = Integer.parseInt(landLoc.substring(3, 5)) % 10;
            System.out.println(i + ", " + j);
            Land plot = theMap.whatLand(i, j);
            Player p = players[turn - 1];
            if (plot.isOwned() & p.equals(plot.getOwner()) & !plot.hasMule()) {
                plot.setMule(p.getMule());


                Image muleImage = new Image("/views/M.U.L.E..png", 20, 20, true, false);
                ImagePattern imagePattern = new ImagePattern(muleImage);
                mul.setFill(imagePattern); //check to make sure this doesn't override color


                currentState = State.MAP; //is this where we want the screen to go to?
            } else {
                //TODO present proper error message
                System.out.println("Improper location for your MULE. It has successfully escaped your grasp and ran away.");
                p.getMule();
            }
            currentState = State.MAP;
        }
    }

    public static int buyPhaseEndTurn() {
        boolean noMoney = true; //make prettier later
        while (noMoney && buyPhaseSkipped < numOfPlayers) {
            turn = turn % numOfPlayers + 1;
            totalTurns++;
            round = (totalTurns-1) / numOfPlayers;
            if (players[turn - 1].getMoney() < LAND_PRICE) {
                buyPhaseSkipped++;
            } else {
                noMoney = false;
            }
        }

        if (buyPhaseSkipped >= numOfPlayers) {
            currentState = State.MAP;
            ScreenNavigator.instance.togglePassButton();
            if (turn != 1) {
                totalTurns = totalTurns + numOfPlayers - turn + 1;
                round++;
                turn = 1;
            }
            reorderPlayers();
            timer.startTime();
        }
        return turn;
    }
    public static int endTurn() {
        ArrayList<Land> plots = currentPlayer().getLand();
        for (Land plot: plots) {
            System.out.println("HERE2");
            plot.produce();
        }
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-1) / numOfPlayers;
        if (turn == 1) {
            reorderPlayers();
        }
        if (round < 14) {
            timer.startTime();
        }
        return turn;
    }

    public static void incrementTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-1) / numOfPlayers;
        //use this only for player config
    }

    public static void reorderPlayers() {
        System.out.println("Reordered");
        for(int i = 0; i < numOfPlayers - 1; i++) {
            System.out.println("i: " + i);
            for (int j = i + 1; j < numOfPlayers; j++) {
                System.out.println("j: " + j);
                System.out.println(players[i].getName() + " checked with " + players[j].getName());
                if (players[i].getScore() > players[j].getScore()) {
                    System.out.println(players[i].getName() + " switched with " + players[j].getName());
                    Player temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }

        }
        System.out.println("New player order:\n" + playersToString());

    }

    public static void townClicked() {
        if (currentState == State.MAP || currentState == State.STORE) {
            ScreenNavigator.instance.loadTown();
            currentState = State.IN_TOWN;
        }
    }

    public static int getTotalTurns() {
        return totalTurns;
    }

    public static int getTurn() {
        return turn;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setConfigurationSettings(int difficulty, int numOfPlayers) {
        Game.difficulty = difficulty;
        Game.setNumOfPlayers(numOfPlayers);
        currentState = State.CONFIG;
        ScreenNavigator.instance.loadNewPlayer();
    }

    public static void addPlayer(String race, Color c, String name) {
        notAllowed.add(c);
        players[turn-1] = new Player(name, race, c);
        originalPlayers[turn-1] = players[turn-1];
        //System.out.println(Game.getNumOfPlayers() + ": " + Game.getTurn() + ": " + Game.getTotalTurns());
        incrementTurn();
        if (getNumOfPlayers() >= getTurn() && getTotalTurns() == getTurn()) {
            ScreenNavigator.instance.loadNewPlayer();
        } else {
            ScreenNavigator.instance.loadMap();
            currentState = State.BUYPHASE;
        }
    }

    public static Boolean purchaseCart(ObservableList<Resource> cart, ListView<Resource> listView) {
        Player p = players[turn - 1];
        Object[] stuff = cart.toArray();
        for (Object thing: stuff) {
            Resource item = (Resource) thing;
            //Make enums later for price
            int price = item.getPrice();
            if (p.getMoney() < price){
                System.out.println("You do not have enough money.\nUnit price: " + price + ", Your money: " + p.getMoney());
                //consider making it sell only if you can afford all?
                return false;
            } else {
                if (item.getInventory(store) > 0) {
                    p.subtractMoney(price);
                    p.addResource(item);
                    System.out.println(item.buyInventory(store) + " " + thing.toString() + " left");
                    listView.getItems().remove(thing.toString());
                }
            }
        }
        System.out.println(p.getMoney());
        return true;
    }

    public static void enterStore() {
        if (currentState == State.IN_TOWN) {
            ScreenNavigator.instance.loadStore();
            currentState = State.STORE;
        }
    }

    public static void sellItems(ObservableList<Resource> cart, ListView<Resource> listView) {
        Player p = players[turn - 1];
        ArrayList<Resource> playerStuff = p.getResources();
        Object[] cartStuff = cart.toArray();
        for (Object item: cartStuff) {
            Resource item2 = (Resource) item;
            //Make enums later for price
            if (p.contains(item2)){
                p.removeResource(item2);
                item2.sellInventory(store);
                p.addMoney(item2.getPrice());
                listView.getItems().remove(item);
                System.out.println("Congratz Y'all! Just sold " + item);
            } else {
                System.out.println("Sold Nothing");
            }
        }
    }

    //replaced
    public static void getTurnOrder() {
        int temp;
        for(int i = 0; i < players.length; i++) {
            temp = i;
            for (int j = i; j < players.length; j++) {
                if (players[j].getMoney() > players[i].getMoney()) {
                    temp = playerTurn[i];
                    playerTurn[i] = j;
                    playerTurn[j] = temp;
                }
            }

        }
    }

    public static void buyMULE(Resource resource) {
        Player p = players[turn - 1];
        int price = 100;
        price += resource.getStorePriceExtra();
        if (p.getMoney() >= price) {
            Mule newMule = new Mule(resource);
            p.subtractMoney(price);
            currentState = State.MULE_PLACING;
            p.giveMule(newMule); //TODO remove mule when player's turn ends
            ScreenNavigator.instance.loadMap();
        } else {
            System.out.println("Not enough money"); //TODO proper error message
        }
    }

    public static String playersToString() {
        String returnString = "";
        for(Player p : players) {
            if (p != null) {
                returnString = returnString + p.toString() + "\n";
            } else {
                returnString = returnString +  "null\n";
            }
        }
        return returnString;
    }

    public static int moneyValue() {
        return resourcePoints[0];
    }

    public static int landValue() {
        return resourcePoints[1];
    }

    public static int foodValue() {
        return resourcePoints[2];
    }

    public static int smithoreValue() {
        return resourcePoints[3];
    }

    public static int energyValue() {
        return resourcePoints[4];
    }

}
