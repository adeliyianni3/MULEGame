package MULE.models;

import javafx.scene.paint.Color;

/**
 * Created by Ethan on 9/17/2015.
 */
//Just using this as a placeholder so other things compile
public class Player {
    private String name;
    private Race race;
    private Color color;
    private int money;

    // Possible method to solve no color/race issues

    public Player(String name, String sRace, Color color) {
        this.name = name;
//        Race race = null;
//        if (name.equals("Humanoid")) {
//            race = Race.HUMANOID;
//        } else if (name.equals("Flapper")) {
//            race = Race.FLAPPER;
//        } else if (name.equals("Bonzoid")) {
//            race = Race.BONZOID;
//        } else if (name.equals("Ugaite")) {
//            race = Race.UGAITE;
//        } else if (name.equals("Buzzite")) {
//            race = Race.BUZZITE;
//        }
        this.race = Race.valueOf(sRace.toUpperCase());
        this.color = color;
        this.money = race.startMoney();

    }

    public String getName() {
        return name;
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
}
