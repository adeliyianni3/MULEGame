package MULE.models;
import java.util.Random;

/**
 * Created by Antonia on 9/16/2015.
 */
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
    public Player getOwner() {
        return this.owner;
    }
}
