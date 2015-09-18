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
    public Player() {

    }

    public Player(String name, Race race, Color color) {
        this.name = name;
        this.race = race;
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
}
