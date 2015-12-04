package MULE.models;

import MULE.controllers.Game;
import MULE.controllers.MapController;
import MULE.controllers.ScreenNavigator;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.Random;

//Created by Antonia on 9/16/2015.

/**
 * Land class that holds basic information about a piece of Land on the Map.
 */
public class Land {
    private final int TILE_WIDTH = 60;
    private final int TILE_HEIGHT = 60;
    private final int TILE_STARTING_X = 30;
    private final int TILE_STARTING_Y = 50;
    private final int TILE_X_INCREMENT = 60;
    private final int TILE_Y_INCREMENT = 60;
    private final int MULE_X_OFFSET = 23;
    private final int MULE_Y_OFFSET = 14;
    private final int MULE_WIDTH = 24;
    private final int MULE_HEIGHT = 40;
    //Just starting MULE.models.Land with basic info
    /**
     * True if Land is owned, false otherwise.
     */
    private boolean owned = false;
    /**
     * LandType of Land.
     */
    private LandType type;
    /**
     * Mule that the Land holds, null if there is none.
     */
    private Mule mule;
    /**
     * Row of the Land.
     */
    private int row;
    /**
     * Column of the Land.
     */
    private int col; //clarity

    private Rectangle rect;
    private Rectangle mulePic;
    /**
     * No-args constructor.
     */
    public Land() {
    } //need no-args constructor for gson to save

    /**
     * Constructor with LandType and indices.
     * @param t LandType to be set
     * @param r Row location
     * @param c Column location
     */
    public Land(final LandType t, final int r, final int c) {
        type = t;
        row = r;
        col = c;
        rect = new Rectangle();
        rect.setX(TILE_STARTING_X + col * TILE_X_INCREMENT);
        rect.setY(TILE_STARTING_Y + row * TILE_Y_INCREMENT);
        rect.setWidth(TILE_WIDTH);
        rect.setHeight(TILE_HEIGHT);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(2);
        rect.setStrokeType(StrokeType.INSIDE);
        if (t.getImage() != null) {
            rect.setFill(new ImagePattern(t.getImage()));
        }
        else {
            rect.setFill(Color.TRANSPARENT);
        }
        mulePic = new Rectangle();
        mulePic.setX(TILE_STARTING_X + col * TILE_X_INCREMENT + MULE_X_OFFSET);
        mulePic.setY(TILE_STARTING_Y + row * TILE_Y_INCREMENT + MULE_Y_OFFSET);
        mulePic.setWidth(MULE_WIDTH);
        mulePic.setHeight(MULE_HEIGHT);
        mulePic.setFill(Color.TRANSPARENT);
        Land temp = this;
        if (r == 2 && c == 4) {
            rect.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    Game.getInstance().townClicked();
                    Game.getInstance().tweakShowPass();
                }

            });
            mulePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Game.getInstance().townClicked();
                    Game.getInstance().tweakShowPass();
                    }
            });
        }
        else {
            rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Game.getInstance().landClicked(temp);
                    Game.getInstance().tweakShowPass();
                }
            });
            mulePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Game.getInstance().landClicked(temp);
                    Game.getInstance().tweakShowPass();
                }
            });
        }
    }

    public final Rectangle getRect() {
        return rect;
    }

    public final Rectangle getMulePic() {
        return mulePic;
    }

    /**
     * Gets the Row index of this Land.
     * @return The Row index of this Land
     */
    public final int getRow() {
        return row;
    }

    /**
     * Gets the Column index of this Land.
     * @return The Column index of this Land
     */
    public final int getCol() {
        return col;
    }
    /**
     * Checks if this Land is already owned or not.
     * @return true if this Land is owned, false otherwise
     */
    public final boolean isOwned() {
        return owned;
    }
    public final void removeMule() {
        setMule(null);
    }
    /**
     * Sets this land to owned.
     */
    public final void setOwner() {
        owned = true;
    }

    /**
     * Checks if this Land has a MULE or not.
     * @return true if this Land has a Mule
     */
    public final boolean hasMule() {
        return this.mule != null;
    }

    /**
     * Sets a Mule in this Land.
     * @param newMule Mule to be set in this Land
     */
    public final void setMule(final Mule newMule) {
        this.mule = newMule;
    } //MULE vs newMule
//    public void setLandType(LandType type) {
//        this.type = type;
//    }
//    public Mule getMule() { return this.MULE; }
//    public Mule removeMule() {
//        Mule temp = MULE;
//        MULE = null;
//        return temp;
//    }

    /**
     * Finds which Player owns this land.
     * @return Player that owns this land.
     */
    public final Player getOwner() {
        Player p = null;
        for (int i = 0; i < Game.getInstance().getNumOfPlayers(); i++) {
            for (Land l : Game.getInstance().players[i].getLand()) {
                if (l.isSame(this)) {
                    p = Game.getInstance().players[i];
                }
            }
        }
        return p;
    }

    /**
     * For testing purposes.
     * @param players Players
     * @param numOfPlayers Number of players
     * @return Player that owns this Land
     */
    public final Player getOwner(final Player[] players,
                                 final int numOfPlayers) {
        Player p = null;
        for (int i = 0; i < numOfPlayers; i++) {
            for (Land l : players[i].getLand()) {
                if (l.isSame(this)) {
                    p = players[i];
                }
            }
        }
        return p;
    }

    /**
     * Checks if a given land is the same as this one.
     * @param l Land to be checked
     * @return True if land is the same, false otherwise
     */
    private boolean isSame(final Land l) {
        return l.row == row && l.col == col;
    }

    /**
     * Produces product based on provided energy, MULE, and land type.
     */
    public final void produce() {
        Player owner = getOwner();
        if (hasMule()) {
            if (!mule.muleIsBroken()) {
                if (owner.hasEnergy()) {
                    if (owner.siloHasSpace(mule.getResource())) {
                        owner.removeEnergy();
                        owner.addResource(mule.getResource(), mule.produce(type));
                    }
                }
            } else {
                System.out.println(mule + " has broken");
                owner.addMules(mule, row, col);
            }
        }
    }

    /**
     * For testing purposes.
     * @param players Players
     * @param numOfPlayers Number of Players
     */
    public final void produce(final Player[] players, final int numOfPlayers) {
        Player owner = getOwner(players, numOfPlayers);
        if (hasMule()) {
            if (owner.hasEnergy()) {
                owner.removeEnergy();
                owner.addResource(mule.getResource(), mule.produce(type));
            }
        }
    }
    public void uncolor() {
        MapController.landLost(col, row, this);
    }

    public LandType getType() {
        return type;
    }

    public Mule getMule() {
        return mule;
    }


    public boolean moveMule(int direction, int xDirection) {
        mulePic.setY(mulePic.getY() + direction);
        mulePic.setX(mulePic.getX() + xDirection);
//        if (mulePic.getY() + direction <= rect.getY() || mulePic.getY() + mulePic.getHeight() + direction >= rect.getY() + rect.getHeight()) {
//            return false;
//        }
        return true;
    }
}
