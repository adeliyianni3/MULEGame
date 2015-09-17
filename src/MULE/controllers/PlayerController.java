package MULE.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * Created by Aaron on 9/17/2015.
 */
public class PlayerController {
    private StringProperty player = new SimpleStringProperty();
    private Color color;
    public String getPlayer() {
        return player.get();
    }

    public StringProperty playerProperty() {
        return player;
    }

    public void setPlayer(String player) {
        this.player.set(player);
    }
}
