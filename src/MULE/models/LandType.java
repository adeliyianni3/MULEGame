package MULE.models;

// Created by Antonia on 9/17/2015.

/**
 * Enumeration containing Resource production multipliers.
 */
public enum LandType {
    /**
     * Plains multipliers.
     */
    PLAIN(2.0, 3.0, 1.0, 1.0),
    /**
     * River multipliers.
     */
    RIVER(4.0, 2.0, 0.0, 0.0),
    /**
     * Mountain multipliers.
     */
    MOUNTAIN(1.0, 1.0, 2.0, 1.0),
    /**
     * D-Mountain multipliers.
     */
    D_MOUNTAIN(1.0, 1.0, 3.0, 1.0),
    /**
     * T-Mountain multipliers.
     */
    T_MOUNTAIN(1.0, 1.0, 4.0, 1.0);
    /**
     * Food production multiplier.
     */
    private double foodFactor;
    /**
     * Energy production multiplier.
     */
    private double energyFactor;
    /**
     * SmithOre production multiplier.
     */
    private double smithOreFactor;
    /**
     * Crystite production multiplier.
     */
    private double crystiteFactor;

    /**
     * No-args constructor.
     */
    LandType() {
    }

    /**
     * Constructor.
     * @param nFoodFactor Food production multiplier
     * @param nEnergyFactor Energy production multiplier
     * @param nSmithOreFactor SmithOre production multiplier
     * @param nCrystiteFactor Crystite production multiplier
     */
    LandType(final double nFoodFactor, final double nEnergyFactor,
             final double nSmithOreFactor, final double nCrystiteFactor) {
        foodFactor = nFoodFactor;
        smithOreFactor = nSmithOreFactor;
        energyFactor = nEnergyFactor;
        crystiteFactor = nCrystiteFactor;
    }

    /**
     * Gets the Food production multiplier.
     * @return the Food production multiplier
     */
    public double getFoodFactor() {
        return foodFactor;
    }

    /**
     * Gets the Energy production multiplier.
     * @return the Energy production multiplier
     */
    public double getEnergyFactor() {
        return energyFactor;
    }

    /**
     * Gets the SmithOre production multiplier.
     * @return the SmithOre production multiplier
     */
    public double getSmithOreFactor() {
        return smithOreFactor;
    }

    /**
     * Gets the Crystite production multiplier.
     * @return the Crystite production multiplier
     */
    public double getCrystiteFactor() {
        return crystiteFactor;
    }

}
