package MULE.models;

import MULE.controllers.Game;

//Created by Antonia on 9/16/2015.
public class Land {
    //Just starting MULE.models.Land with basic info
    private boolean owned = false;
    private LandType type;
    private Mule mule;

    public int i;
    public int j;
    public Land(){}
    public Land(LandType type) {
        this.type = type;
    }
    public Land(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Land(LandType type, int i, int j) {
        this.type = type;
        this.i = i;
        this.j = j;
    }
    public boolean isOwned() {
        return owned;
    }
    public void setOwner(Player p) {
        owned = true;
    }
    public boolean hasMule() {
        return this.mule != null;
    }
    public void setMule(Mule newMule) {
        this.mule = newMule;
    }
    public void setLandType(LandType type) {
        this.type = type;
    }
    public Mule getMule() { return this.mule; }
    public Mule removeMule() {
        Mule temp = mule;
        mule = null;
        return temp;
    }
    public Player getOwner() {
        Player p = null;
        for (int i = 0; i < Game.instance.numOfPlayers; i++) {
            for (Land l : Game.instance.players[i].getLand()) {
                if (l.isSame(this)) {
                    p = Game.instance.players[i];
                }
            }
        }
        return p;
    }

    public boolean isSame(Land l) {
        return l.i == i && l.j == j;
    }

    public void produce() {
        Player owner = getOwner();
        if (hasMule()) {
            if (owner.hasEnergy()) {
                owner.removeEnergy();
                owner.addResource(mule.getResource(), mule.produce(type));
            }
        }
    }
}
