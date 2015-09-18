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

    public Player(String name, Race race, Color color) {
        this.name = name;
        this.race = race;
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
