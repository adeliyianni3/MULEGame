package Mule.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;

/**
 * Created by Aaron on 9/11/2015.
 */
public class Player {
    private String name;
    private Race race;
    private Color color;
    private int food = 0;
    private int money = 1000;


    public Player(String name, Race race, Color color) {
        this.name = name;
        this.race = race;
        this.color = color;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    public void setColor(Color color) {
        this.color = color;
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
    public String toString() {
        return name + " of race: " + race + " and color: " + color;
    }
}
