package MULE.models;

/**
 * Created by Antonia on 9/17/2015.
 */
public enum LandType {
    PLAIN(2.0, 3.0, 1.0, 1.0),
    RIVER(4.0, 2.0, 0.0, 0.0),
    MOUNTAIN(1.0, 1.0, 2.0, 1.0),
    D_MOUNTAIN(1.0, 1.0, 3.0, 1.0),
    T_MOUNTAIN(1.0, 1.0, 4.0, 1.0);

    private double foodFactor;
    private double energyFactor;
    private double smithOreFactor;
    private double crystiteFactor;


    LandType(double foodFactor, double energyFactor, double smithOreFactor, double crystiteFactor) {
        this.foodFactor = foodFactor;
        this.smithOreFactor = smithOreFactor;
        this.energyFactor = energyFactor;
        this.crystiteFactor = crystiteFactor;
    }
    public double getFoodFactor() {
        return foodFactor;
    }
    public double getEnergyFactor() {
        return energyFactor;
    }
    public double getSmithOreFactor() {
        return smithOreFactor;
    }
    public double getCrystiteFactor() {
        return crystiteFactor;
    }
}
