package MULE.models;

import MULE.controllers.Game;
import javafx.scene.paint.Color;

import java.util.ArrayList;

// Created by Ethan on 9/17/2015.
//Just using this as a placeholder so other things compile
public class Player {
    private static int playerNumber = 1;
    private String name;
    private Race race;
    private Color color;
    private int id;
    private Mule mule;
    private int money;
    private int score;
    private int[] numOfResources; //energy, food, smithore, and crystite
    private int numOfLands;
    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public Mule getMule() {
        Mule temp = mule;
        mule = null;
        return temp;
    }

    public int getEnergy() {
        return numOfResources[0];
    }

    public int getFood() {
        return numOfResources[1];
    }

    public int getNumOfLands() {
        return numOfLands;
    }

    public int getSmithore() {
        return numOfResources[2];
    }

    public int getCrystite() {
        return numOfResources[3];
    }

    public void giveMule(Mule mule) {
        this.mule = mule;
    }

    public void sellLand() {
        //TODO
    }

    // Possible method to solve no color/race issues
    public Player(String name, String sRace, Color color) {
        this.name = name;
        this.race = Race.valueOf(sRace.toUpperCase());
        this.color = color;
        this.money = race.startMoney();
        this.id = playerNumber;
        numOfLands = 0;
        numOfResources = new int[4];

        for (int i = 0; i < 4; i = i + 1) {
            addResource(Resource.ENERGY);
        }
        for (int i = 0; i < 8; i = i + 1) {
            addResource(Resource.FOOD);
        }
        playerNumber++;

    }

    public void incrementLand() {
        numOfLands++;
    }

    public String getName() {
        return name;
    }

    public void addResource(Resource source) {
        if (source.equals(Resource.MULE)){
            mule = new Mule();
        } else {
            resources.add(source);
            if (source.equals(Resource.FOOD)) {
                numOfResources[1] = numOfResources[1] + 1;
            }
            if (source.equals(Resource.ENERGY)) {
                numOfResources[0] = numOfResources[0] + 1;
            }
            if (source.equals(Resource.SMITH_ORE)) {
                numOfResources[2] = numOfResources[2] + 1;
            }
            if (source.equals(Resource.CRYSTITE)) {
                numOfResources[3] = numOfResources[3] + 1;
            }
        }
    }
    public int foodCounter() {
        return numOfResources[1];
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public boolean contains(Resource source) {
        return resources.contains(source);
    }

    public void removeResource(Resource source) {
        if (source.equals(Resource.MULE)){
            mule = null;
        } else if (resources.contains(source)) {
            resources.remove(source);
            if (source.equals(Resource.FOOD)) {
                numOfResources[1] = numOfResources[1] - 1;
            }
            if (source.equals(Resource.ENERGY)) {
                numOfResources[0] = numOfResources[0] - 1;
            }
            if (source.equals(Resource.SMITH_ORE)) {
                numOfResources[2] = numOfResources[2] - 1;
            }
            if (source.equals(Resource.CRYSTITE)) {
                numOfResources[3] = numOfResources[3] - 1;
            }
        }
    }

    public Race getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public void addMoney(int amount) {
        money = money + amount;
    }

    public void subtractMoney(int amount) {
        money = money - amount;
    }

    public int getMoney() {
        return money;
    }

    public int getScore() {
        int totalScore = 0;

        totalScore += Game.moneyValue() * getMoney();
        totalScore += numOfLands * Game.landValue(); //getSumLand() * getLandPrice()
        totalScore += numOfResources[0] * Game.energyValue(); //energy
        totalScore += numOfResources[1] * Game.foodValue();//food
        totalScore += numOfResources[2] * Game.smithoreValue();//smithore


        return totalScore; }

    public String toString() {
        return "Player name: " + name + ", race: " + race + ", color: " + color + ", money: " + money + ", score: " + getScore();
    }

    public void outfitMule(Resource resource) {
        if (hasMule()) {
            this.mule.setResource(resource);
        }
    }

    public boolean hasMule() {
        return this.mule != null;
    }
}
