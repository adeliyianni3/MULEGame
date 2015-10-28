package MULE.models;

import MULE.controllers.Game;

//Created by Antonia on 9/16/2015.
public class Land {
    //Just starting MULE.models.Land with basic info
    private boolean owned = false;
    private LandType type;
    private Mule mule;

    public Land(LandType type) {
        this.type = type;
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
                if (l.equals(this)) {
                    p = Game.instance.players[i];
                }
            }
        }
        return p;
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
