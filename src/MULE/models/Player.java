package MULE.models;

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
    private int[] arr;
    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public Mule getMule() {
        return mule;
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
        playerNumber++;

    }

    public String getName() {
        return name;
    }

    public void addResource(Resource source) {
        if (source.equals(Resource.MULE)){
            mule = new Mule();
        } else {
            resources.add(source);
        }
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
        arr = new int[2];
        arr[0] = getMoney();
        arr[1] = 1; //getSumLand() * getLandPrice()
        arr[2] = 1; // amountEnergy() + amountFood(); + amountOre();
        int totalScore = 0;
        for (int i : arr) {
            totalScore += i + totalScore;
        }
        return totalScore; }

    public String toString() {
        return "Player name: " + name + ", race: " + race + ", color: " + color + ", money: " + money;
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
