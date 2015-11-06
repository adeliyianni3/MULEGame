package MULE.controllers;


import MULE.Main;
import MULE.models.Player;
import MULE.models.Map;
import MULE.models.RandomEvent;
import MULE.models.Race;
import MULE.models.InterfaceAdapter;
import MULE.models.EventOne;
import MULE.models.EventTwo;
import MULE.models.EventThree;
import MULE.models.EventFour;
import MULE.models.EventFive;
import MULE.models.EventSix;
import MULE.models.EventSeven;
import MULE.models.PlayerTimer;
import MULE.models.ResourceStore;
import MULE.models.Resource;
import MULE.models.Land;
import MULE.models.Mule;

import com.google.gson.GsonBuilder;

import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import com.google.gson.Gson;


import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game {
    private static final int MAX_ROUND = 14;
    private static final int BONUS = 250;
    private static final int RANDOM_EVENT_PROBABILITY = 27;
    private static final int MAX_PROBABILITY = 101;
    private static final int NUMBER_GOOD_EVENTS = 4;
    public static Game instance = new Game();
    private String lastEvent = "---"; //ONLY DEBUG
    private final ArrayList<Color> notAllowed = new ArrayList<>();
    private int numOfPlayers = 1;
    private final int DEFAULT_PLAYER_AMOUNT = 0; //why is this 0?
    private int round = 0;
    public Player[] players = new Player[DEFAULT_PLAYER_AMOUNT];
    private Player[] originalPlayers = new Player[DEFAULT_PLAYER_AMOUNT];
    private int difficulty;
//    private int mapType;
//    private int[] playerTurn; //unused?
    private int totalTurns = 1;
    private int turn = 1;
    private State currentState = State.MAIN;
    public final PlayerTimer timer = new PlayerTimer();
    private final ResourceStore store = new ResourceStore();
    private final int[] resourcePoints = {1, 500, 1, 1, 1}; //holds point values of money, land, energy, smithore, food
    private static final RandomEvent[] possibleEvents = {new EventOne(), new EventTwo(), new EventThree(), new EventFour(), new EventFive(), new EventSix(), new EventSeven()};
    private final boolean[][] muleArray = new boolean[5][9];
    private final Color[][] colorArray = new Color[5][9];
    private transient MediaPlayer mediaPlayer = null;
    //if making music selectable, change from final
    private final URL songFile = getClass().getResource("/audio/Edward_Shallow_-_02_-_Merchant.mp3");

    private final Map theMap = new Map();
    private int buyPhaseSkipped = 0;
    
    private final int LAND_PRICE = 300;

    public static Game getInstance() {
        return instance;
    }

    public static void setInstance(GameDummy instance) {
        Game.instance = instance;
    }

    public State getCurrentState() {
        return currentState;
    }

    public URL getSongFile() {
        return songFile;
    }

    public Color[][] getColorArray() {
        return colorArray;
    }

    public boolean[][] getMuleArray() {
        return muleArray;
    }

    public void saveGame() {
        try {
            try (PrintWriter out = new PrintWriter(new File("data.json"))) {
                Gson gs = new GsonBuilder().registerTypeAdapter(Race.class, new InterfaceAdapter()).registerTypeAdapter(Color.class, new ColorInstanceCreator()).registerTypeAdapter(Resource.class, new InterfaceAdapter()).create();
                String gson = gs.toJson(this);
                out.print(gson);
                System.out.println(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadGame() {
        try {
            Game.instance.pauseMusic();
            try (BufferedReader br = new BufferedReader(new FileReader("data.json"))) {
                String json = br.readLine();
                System.out.println(json);
                Gson gs = new GsonBuilder().registerTypeAdapter(Race.class, new InterfaceAdapter()).registerTypeAdapter(Color.class, new ColorInstanceCreator()).registerTypeAdapter(Resource.class, new InterfaceAdapter()).create();
                instance = gs.fromJson(json, Game.class);
                Main.makeMusic(getSongFile());
            }
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        ScreenNavigator.getInstance().loadLoadedMap();
        switch (instance.currentState) {
            case MAP:
            case MULE_PLACING:
            case BUY_PHASE: ScreenNavigator.getInstance().loadMap();
                break;
            case STORE: ScreenNavigator.getInstance().loadStore();
                break;
            case IN_TOWN: ScreenNavigator.getInstance().loadTown();
                break;
            case MAIN: ScreenNavigator.getInstance().loadMain();
                break;
            case CONFIG: ScreenNavigator.getInstance().loadNewPlayer();
                break;
            default: System.out.println("Something went wrong in loadGame().");
                break;
        }
        if (instance.colorArray[0][0] == null) {
            System.out.println("Null");
        } else {
            System.out.println(instance.colorArray[0][0].getClass());
        }
        if (instance.players[0] == null) {
            System.out.println("Null Players");
        }
        if (instance.theMap.whatLand(0,0) == null) {
            System.out.println("Null Map");
        }
        for (int i = 0; i < instance.numOfPlayers; i++) {
            for (int j = 0; j < instance.numOfPlayers; j++) {
                if (instance.players[i].getName().equals(instance.originalPlayers[j].getName())) {
                    instance.originalPlayers[j] = instance.players[i];
                }
            }
        }
    }


    // public void leaveTown(String side) use this if implementing moving sprites
    public void leaveTown() {
        currentState = State.MAP;
    }


    public void leaveStore() {
        currentState = State.IN_TOWN;
    }


    public void randomEvent(){
        Random random = new Random();
        int chance = random.nextInt(MAX_PROBABILITY);
        if (chance <= RANDOM_EVENT_PROBABILITY) {
            int x = chance % possibleEvents.length;
            if (currentPlayer() == getPlayers()[0] && x > 3) {
                x = chance % NUMBER_GOOD_EVENTS;
            }
            RandomEvent event = possibleEvents[x];
            lastEvent = event.apply(currentPlayer());
        }
    }
    //ONLY FOR DEBUG
    public String getLastEvent() {
        return lastEvent;
    }

    public Map getTheMap() {
        return theMap;
    }

    public enum State{
        MAIN, CONFIG, IN_TOWN, /*AUCTION,*/ BUY_PHASE, MAP, STORE, MULE_PLACING
    }

    public void setMediaPlayer(MediaPlayer mp) {
        mediaPlayer = mp;
    }

    public void playMusic() {
        mediaPlayer.play();
    }

    public void pauseMusic() {
        mediaPlayer.pause();
    }

    public void changeState(State s) {
        currentState = s;
    }

    public int getDifficulty() {
        return difficulty;
    }


//    public int getMapType() {
//        return mapType;
//    }

//    public void setMapType(int mapType) {
//        this.mapType = mapType;
//    }

    void setNumOfPlayers(int num) {
        numOfPlayers = num;
        players = new Player[num];
        originalPlayers = new Player[num];
//        playerTurn = new int[num];
//        for (int i = 0; i < num; i++) {
//            playerTurn[i] = i + 1;
//        }
    }

//    public ArrayList<Color> getColors() {
//        return notAllowed;
//    }

    public boolean isColorAvailable(Color c) {
        return !notAllowed.contains(c);
    }

    public void useAssay() {
        System.out.println("Not yet implemented");
    }

    public void useLandOffice() {
        System.out.println("Not yet implemented");
    }

    public int getRound() {
        return round;
    }

    public State getPhase() {
        return currentState;
    }

    public Player[] getPlayers() {
        return players;
    }
    public Player[] getOriginalPlayers() {
        return originalPlayers;
    }

    public void gamble() {
        int[] roundBonus = {50, 50 ,50, 100, 100, 100, 100, 150, 150, 150, 150, 200};
        int timeBonus;
        int bonus;
        Random rand = new Random();
        int time = timer.getTime();
        System.out.println(time);
        if (time <= 12){
            timeBonus = 50;
        } else if (time <= 25){
            timeBonus = 100;
        } else if (time <= 37){
            timeBonus = 150;
        } else{
            timeBonus = 200;
        }
        bonus = roundBonus[round - 3]+rand.nextInt(timeBonus + 1);
        if (bonus > BONUS){
            bonus = BONUS;
        }
        players[turn-1].addMoney(bonus);
        System.out.println("Gambled and won " + bonus + ".");
        timer.stopTime();
    }

    public void buyPhaseSkip() {
        System.out.println("buyPhaseSkip() called.");
        if (currentState.equals(State.BUY_PHASE)) {
            System.out.println("buyPhaseSkip() executed.");
            buyPhaseSkipped++;
            buyPhaseEndTurn();
        }
    }

    Player currentPlayer() {
        return players[getTurn() - 1];
    }
    public void landClicked(String landLoc, Rectangle rec, Rectangle mul) {
        if (currentState.equals(State.BUY_PHASE)) {
            System.out.println("Round:" + round);
            int i = Integer.parseInt(landLoc.substring(3, 5)) / 10;
            int j = Integer.parseInt(landLoc.substring(3, 5)) % 10;
            System.out.println(i + ", " + j);
            Land plot = theMap.whatLand(i, j);
            System.out.println("Turn: " + turn + ", Total Turns: " + totalTurns);
            if (!plot.isOwned()) {
                Player p = players[turn - 1];
                if (round < 3) {
                    plot.setOwner();
                    p.addLand(plot);
                    rec.setStroke(p.getColor());
                    colorArray[i][j] = p.getColor();
                    rec.setStrokeWidth(4.0);
                    p.incrementLand();
                    buyPhaseSkipped = 0;
                    buyPhaseEndTurn();
                } else {
                    if (p.getMoney() >= LAND_PRICE) {
                        plot.setOwner();
                        p.addLand(plot);
                        rec.setStroke(p.getColor());
                        colorArray[i][j] = p.getColor();
                        rec.setStrokeWidth(4.0);
                        p.subtractMoney(LAND_PRICE);
                        p.incrementLand();
                        buyPhaseSkipped = 0;
                        buyPhaseEndTurn();
                    }
                }
            }
            if (round == 3 && turn == 1) {
                ScreenNavigator.getInstance().togglePassButton();
            }


            System.out.println(playersToString()); //debug statement
        } else if (currentState.equals(State.MULE_PLACING)) {
            int i = Integer.parseInt(landLoc.substring(3, 5)) / 10;
            int j = Integer.parseInt(landLoc.substring(3, 5)) % 10;
            System.out.println(i + ", " + j);
            Land plot = theMap.whatLand(i, j);
            Player p = players[turn - 1];
            System.out.println(plot.isOwned() + " " + p.equals(plot.getOwner()) + " " + !plot.hasMule());
            if (plot.isOwned() & p.equals(plot.getOwner()) & !plot.hasMule()) {
            //if (plot.isOwned() & doesPlayerOwn(p, plot) & !plot.hasMule()) {
                plot.setMule(p.getMule());
                muleArray[i][j] = true;

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

    public boolean doesPlayerOwn(Player p, Land l) {
        boolean returnValue = false;
        for (Land pl : p.getLand()) {
            if (pl.getRow() == l.getRow() && pl.getCol() == l.getCol()) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    void buyPhaseEndTurn() {
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
            ScreenNavigator.getInstance().togglePassButton();
            if (turn != 1) {
                totalTurns = totalTurns + numOfPlayers - turn + 1;
                round++;
                turn = 1;
            }
            reorderPlayers();
            timer.startTime();
        }
    }
    public void endTurn() {
        ArrayList<Land> plots = currentPlayer().getLand();
        for (Land plot: plots) {
            plot.produce();
        }
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-1) / numOfPlayers;
        if (turn == 1) {
            reorderPlayers();
        }
        System.out.println(round + " " + (round > MAX_ROUND));
        if (round <= MAX_ROUND && getPhase() != State.BUY_PHASE) {
            timer.startTime();
        } else {
            currentState = State.MAIN; //swap out with display scores later
            ScreenNavigator.getInstance().loadMain();
        }
    }

    void incrementTurn() {
        turn = turn % numOfPlayers + 1;
        totalTurns++;
        round = (totalTurns-1) / numOfPlayers;
        //use this only for player config
    }

    private void reorderPlayers() {
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

    public void townClicked() {
        if (currentState == State.MAP || currentState == State.STORE) {
            ScreenNavigator.getInstance().loadTown();
            currentState = State.IN_TOWN;
        }
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public int getTurn() {
        return turn;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setConfigurationSettings(int difficulty, int numOfPlayers) {
        this.difficulty = difficulty;
        setNumOfPlayers(numOfPlayers);
        currentState = State.CONFIG;
        ScreenNavigator.getInstance().loadNewPlayer();
        System.out.println(Game.instance.getDifficulty());
    }

    public void addPlayer(String race, Color c, String name) {
        notAllowed.add(c);
        players[turn-1] = new Player(name, race, c);
        originalPlayers[turn-1] = players[turn-1];
        incrementTurn();
        if (getNumOfPlayers() >= getTurn() && getTotalTurns() == getTurn()) {
            ScreenNavigator.getInstance().loadNewPlayer();
        } else {
            ScreenNavigator.getInstance().loadMap();
            currentState = State.BUY_PHASE;
        }
    }

    public void enterStore() {
        if (currentState == State.IN_TOWN) {
            ScreenNavigator.getInstance().loadStore();
            currentState = State.STORE;
        }
    }

    public ResourceStore getStore() {
        return store;
    }

    //replaced
//    public void getTurnOrder() {
//        int temp;
//        for(int i = 0; i < players.length; i++) {
//            for (int j = i; j < players.length; j++) {
//                if (players[j].getMoney() > players[i].getMoney()) {
//                    temp = playerTurn[i];
//                    playerTurn[i] = j;
//                    playerTurn[j] = temp;
//                }
//            }
//
//        }
//    }

    public void buyMULE(Resource resource) {
        Player p = players[turn - 1];
        int price = 100;
        price += resource.getStorePriceExtra();
        if (p.getMoney() >= price) {
            Mule newMule = new Mule(resource);
            p.subtractMoney(price);
            currentState = State.MULE_PLACING;
            p.giveMule(newMule); //TODO remove mule when player's turn ends
            ScreenNavigator.getInstance().loadMap();
        } else {
            System.out.println("Not enough money"); //TODO proper error message
        }
    }

    String playersToString() {
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

    public int moneyValue() {
        return resourcePoints[0];
    }

    public int landValue() {
        return resourcePoints[1];
    }

    public int foodValue() {
        return resourcePoints[2];
    }

    public int smithoreValue() {
        return resourcePoints[3];
    }

    public int energyValue() {
        return resourcePoints[4];
    }

}



