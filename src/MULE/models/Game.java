package MULE.models;

/**
 * Created by Aaron on 9/17/2015.
 */
public class Game {
    public static int numOfPlayers = 1;
    public static int playerConfiguration = 0;
    public static final int DEFAULT_PLAYER_AMOUNT = 0;

    public static Player[] players = new Player[DEFAULT_PLAYER_AMOUNT];
    private static int difficulty;
    private static int mapType;

    private static int totalTurns = 1;
    private static int turn = 1;
    public static State currentState = State.MAIN;

    public enum Resource {
        FOOD, ORE, CRYSTALITE, ENERGY;
    }

    public enum State{
        MAIN, CONFIG, MAP, TOWN, AUCTION;
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

    }

    public static int endTurn() {
        turn = turn + 1 % numOfPlayers + 1;
        totalTurns++;
        return turn;
    }

    public static void incrementTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
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

    public static void actionRelay(String message) {
        //For now we will awkwardly parse messages from the ScreenNavigator here, we'll look into listeners later
        switch(currentState) {
            case MAIN:
                break;
            case CONFIG:
                break;
            case MAP:
                break;
            case TOWN:
                break;
            case AUCTION:
                break;
            default:
                System.out.println("This shouldn't have been possible. Main.actionRelay() error.");
        }
    }

}
