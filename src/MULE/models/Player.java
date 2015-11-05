package MULE.models;

import MULE.controllers.Game;
import javafx.scene.paint.Color;

import java.util.ArrayList;

// Created by Ethan on 9/17/2015.
//Just using this as a placeholder so other things compile
public class Player {
    private String name;
    private Race race;
    private Color color;
    private Mule mule;
    private int money;
    private int[] numOfResources; //energy, food, smithore, and crystite
    private int numOfLands;
    private ArrayList<Land> landOwned = new ArrayList<>();

    public Mule getMule() {
        Mule temp = mule;
        mule = null;
        return temp;
    }

    public void addLand(Land land) {
        System.out.println("HERE");
        landOwned.add(land);
    }

    public ArrayList<Land> getLand() {
        return landOwned;
    }

    public int getEnergy() {
        return numOfResources[0];
    }

    public boolean hasEnergy() {
        return numOfResources[0] > 0;
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

    public Player() {

    }
    public Player(String name, String sRace, Color color) {
        this.name = name;
        try {
            String newsRace = sRace.substring(0, 1).toUpperCase() + sRace.substring(1);
            Class<?> c = Class.forName("MULE.models." + newsRace);
            this.race = (Race) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.color = color;
        this.money = race.startMoney();

        numOfLands = 0;
        numOfResources = new int[4];

        for (int i = 0; i < 4; i = i + 1) {
            Energy resource = new Energy();
            addResource(resource);
        }
        for (int i = 0; i < 8; i = i + 1) {
            Food resource = new Food();
            addResource(resource);
        }

    }

    public void incrementLand() {
        numOfLands++;
    }

    public String getName() {
        return name;
    }

    public void addResource(Resource source) {
        numOfResources[source.getID()] = numOfResources[source.getID()] + 1;
    }

    public void addResource(Resource source, int amount) {
        numOfResources[source.getID()] = numOfResources[source.getID()] + amount;
    }

    public void addFood(int amount) {
        addResource(new Food(), amount);
    }

    public void addEnergy(int amount) {
        addResource(new Energy(), amount);
    }

    public void addSmithOre(int amount) {
        addResource(new SmithOre(), amount);
    }

    public void addCrystite(int amount) {
        addResource(new Crystite(), amount);
    }

    public int foodCounter() {
        return numOfResources[1];
    }

    public boolean contains(Resource source) {
        return numOfResources[source.getID()] > 0;
    }

    public void removeResource(Resource source) {
        numOfResources[source.getID()] = numOfResources[source.getID()] - 1;
    }

    public void removeEnergy() {
        removeResource(new Energy());
    }

    public void removeFood() {
        removeResource(new Food());
    }

    public void removeSmithOre() {
        removeResource(new SmithOre());
    }

    public void removeCrystite() {
        removeResource(new Crystite());
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

        totalScore += Game.instance.moneyValue() * getMoney();
        totalScore += numOfLands * Game.instance.landValue(); //getSumLand() * getLandPrice()
        totalScore += numOfResources[0] * Game.instance.energyValue(); //energy
        totalScore += numOfResources[1] * Game.instance.foodValue();//food
        totalScore += numOfResources[2] * Game.instance.smithoreValue();//smithore


        return totalScore; }

    public String toString() {
        return "Player name: " + name + ", race: " + race + ", color: " + color + ", money: " + money + ", score: " + getScore();
    }

    public boolean hasMule() {
        return this.mule != null;
    }
}
