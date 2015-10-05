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
            if (getOwner().contains(Resource.ENERGY)) {
                getOwner().removeResource(Resource.ENERGY);
                Resource sown = getMule().getResource();
                double factor;
                if (sown.equals(Resource.ENERGY)) {
                    factor = type.getEnergyFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(Resource.ENERGY);
                    }
                }
                if (sown.equals(Resource.FOOD)) {
                    factor = type.getFoodFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(Resource.FOOD);
                    }
                }
                if (sown.equals(Resource.SMITH_ORE)) {
                    factor = type.getSmithOreFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(Resource.SMITH_ORE);
                    }
                }
                if (sown.equals(Resource.CRYSTITE)) {
                    factor = type.getCrystiteFactor();
                    for (int i = 0; i < factor; i = i + 1) {
                        getOwner().addResource(Resource.CRYSTITE);
                    }
                }
            }
        }
    }
}
