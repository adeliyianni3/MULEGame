package MULE.models;

//Created by Antonia on 9/16/2015.
public class Land {
    //Just starting MULE.models.Land with basic info
    private Player owner = null;
    private LandType type;
    private Mule mule;

    public Land(LandType type) {
        this.type = type;
    }
    public boolean isOwned() {
        return this.owner != null;
    }
    public void setOwner(Player p) {
        this.owner = p;
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
        return this.owner;
    }

    public void produce() {
        if (hasMule()) {
            if (owner.hasEnergy()) {
                owner.removeEnergy();
                owner.addResource(mule.getResource(), mule.produce(type));
            }
        }
    }
}
