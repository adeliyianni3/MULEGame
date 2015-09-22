package MULE.models;

/**
 * Created by Antonia on 9/17/2015.
 */
public enum LandType {
    PLAIN(0.5, 1.0, 0.5),
    RIVER(1.0, 0.5, 0.0),
    MOUNTAIN(0.5, 0.5, 1.0),
    D_MOUNTAIN(0.25, 0.25, 1.5),
    T_MOUNTAIN(0.1, 0.1, 2.0);

    private double foodFactor;
    private double energyFactor;
    private double smithOreFactor;
//    private double crystaliteFactor;


    LandType(double foodFactor, double energyFactor, double smithOreFactor) {
        this.foodFactor = foodFactor;
        this.smithOreFactor = smithOreFactor;
        this.energyFactor = energyFactor;
    }
}
