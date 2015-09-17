package MULE.models;

/**
 * Created by Aaron on 9/17/2015.
 */
public class Game {
    public static int numOfPlayers = 1;
    public static int playerConfiguration = 0;

    public static Player[] players = new Player[4];
    private static int difficulty;
    private static int mapType;

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
}
