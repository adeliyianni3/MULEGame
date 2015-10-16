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
            Energy a = new Energy();
            if (getOwner().hasEnergy()) {
                getOwner().removeResource(a);
                Resource sown = getMule().getResource();
                double factor;
                if (sown instanceof Energy) {
                    factor = type.getEnergyFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(a);
                    }
                }
                if (sown instanceof Food) {
                    Food b = new Food();
                    factor = type.getFoodFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(b);
                    }
                }
                if (sown instanceof SmithOre) {
                    SmithOre c = new SmithOre();
                    factor = type.getSmithOreFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(c);
                    }
                }
                if (sown instanceof Crystite) {
                    Crystite d = new Crystite();
                    factor = type.getCrystiteFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(d);
                    }
                }
            }
        }
    }
}
