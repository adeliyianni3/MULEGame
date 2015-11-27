package MULE.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Antonia on 11/27/2015.
 */
public abstract class LandType {
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
    private Image image;
    /**
     * Gets the Food production multiplier.
     * @return the Food production multiplier
     */
    public double getFoodFactor() {
        return foodFactor;
    }

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
    public void setImage(Image im) {
        image = im;
    }
    public Image getImage() {
        return image;
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
