package MULE.models;

import MULE.controllers.ScreenNavigator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Created by Aaron on 9/17/2015.
 */
public class Game {
    public static int numOfPlayers = 1;
    public static int playerConfiguration = 0;
    public static final int DEFAULT_PLAYER_AMOUNT = 0;
    public static int round = 0;
    public static Player[] players = new Player[DEFAULT_PLAYER_AMOUNT];
    private static int difficulty;
    private static int mapType;
    private static int[] playerTurn;
    private static int totalTurns = 1;
    private static int turn = 1;
    public static State currentState = State.MAIN;

    private static Map theMap = new Map();
    public static int LAND_PRICE = 300;

    public static int numLand = 1;

    public static void leaveTown(String side) {
        //TODO
    }


    public enum State{
        MAIN, CONFIG, IN_TOWN, AUCTION, BUYPHASE;
    }

//    public enum ScreenState{
//        MAIN, CONFIG, MAP, TOWN;
//    }

    public static void changeState(State s) {
        currentState = s;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        Game.difficulty = difficulty;
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
        playerTurn = new int[num];
        for (int i = 0; i < num; i++) {
            playerTurn[i] = i + 1;
        }
    }

    public static void storeClicked(String storeLoc) {
        switch(storeLoc) {
            case "Pub":
                gamble();
                endTurn();
                break;
            case "mulePen":
                players[Game.getTurn() - 1].buyMule();
                break;
            case "food":
                players[Game.getTurn() - 1].outfitMule(Resource.FOOD);
                break;
            case "smithOre":
                players[Game.getTurn() - 1].outfitMule(Resource.SMITH_ORE);
                break;
            case "energy":
                players[Game.getTurn() - 1].outfitMule(Resource.ENERGY);
                break;
            case "land":
                players[Game.getTurn() - 1].sellLand();
                break;

        }

    }

    private static void gamble(PlayerTimer timer) {
        int[] roundBonus = {50,50,50,100,100,100,100,150,150,150,150,200};
        int timeBonus;
        int bonus;
        Random rand = new Random();
        int time = timer.getTime();
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
    }

    public static void landClicked(String landLoc) {
        int i = Integer.parseInt(landLoc.substring(3, 5))/10;
        int j = Integer.parseInt(landLoc.substring(3, 5))%10;
        Land plot = theMap.whatLand(i, j);
        if (!plot.isOwned()) {
            Player p = players[turn - 1];
            if (round < 3) {
                plot.setOwner(p);
                endTurn();
            } else {
                if (p.getMoney() > LAND_PRICE) {
                    plot.setOwner(p);
                    p.subtractMoney(LAND_PRICE);
                    ScreenNavigator.setLandColor(landLoc, p.getColor());
                }
            }
        }
    }

    public static void landClicked(String landLoc, Rectangle rec) {
        System.out.println("Round:" + round);
        int i = Integer.parseInt(landLoc.substring(3, 5))/10;
        int j = Integer.parseInt(landLoc.substring(3, 5))%10;
        System.out.println(i + ", " + j);
        Land plot = theMap.whatLand(i, j);
        if (!plot.isOwned()) {
            Player p = players[turn - 1];
            if (round < 3) {
                plot.setOwner(p);
                rec.setFill(p.getColor());
                endTurn();
            } else {
                if (p.getMoney() >= LAND_PRICE) {
                    plot.setOwner(p);
                    rec.setFill(p.getColor());
                    p.subtractMoney(LAND_PRICE);
                    ScreenNavigator.setLandColor(landLoc, p.getColor());
                    endTurn();
                }
            }
        }
        System.out.println(playersToString());
    }

    public static int endTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-2) / numOfPlayers;
        return turn;
    }

    public static void incrementTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-2) / numOfPlayers;
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

//    public static void actionRelay(String message) {
//        //For now we will awkwardly parse messages from the ScreenNavigator here, we'll look into listeners later
//        switch(currentState) {
//            case MAIN:
//                break;
//            case CONFIG:
//                break;
//            case MAP:
//                break;
//            case TOWN:
//                break;
//            case AUCTION:
//                break;
//            default:
//                System.out.println("This shouldn't have been possible. Main.actionRelay() error.");
//        }
//    }

    public static void addPlayer(String race, Color c, String name) {
        players[turn-1] = new Player(name, race, c);
    }

    public static void getTurnOrder() {
        int temp = 0;
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

}
