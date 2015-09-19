package MULE.models;

import MULE.controllers.ScreenNavigator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    private static int totalTurns = 1;
    private static int turn = 1;
    public static State currentState = State.MAIN;

    private static GameMap theMap = new GameMap();
    public static int LAND_PRICE = 300;

    public enum Resource {
        FOOD, ORE, CRYSTALITE, ENERGY;
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
    }

    public static void storeClicked(String storeLoc) {

    }

    public static void landClicked(String landLoc) {
        int i = Integer.parseInt(landLoc)/10;
        int j = Integer.parseInt(landLoc)%10;
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
        int i = Integer.parseInt(landLoc)/10;
        int j = Integer.parseInt(landLoc)%10;
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
