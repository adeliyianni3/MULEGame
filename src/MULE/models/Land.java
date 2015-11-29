package MULE.models;

import MULE.controllers.Game;
import MULE.controllers.MapController;
import MULE.controllers.ScreenNavigator;

import java.util.Random;

//Created by Antonia on 9/16/2015.

/**
 * Land class that holds basic information about a piece of Land on the Map.
 */
public class Land {
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
                owner.addMules(mule);
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
}
