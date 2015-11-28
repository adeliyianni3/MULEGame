package MULE.models;

//Created by Antonia on 9/26/2015.

/**
 * Store class that stores information on Resource stock.
 */
public class ResourceStore {
    /**
     * Amount of energy in stock.
     */
    private int energyInventory = 16;
    /**
     * Amount of lumber in stock.
     */
    private int lumberInventory = 0;
    /**
     * Amount of crystite in stock.
     */
    private int crystiteInventory = 0;
    /**
     * Amount of food in stock.
     */
    private int foodInventory = 16;
    /**
     * Amount of smithore in stock.
     */
    private int smithoreInventory = 0;
//    private int muleInventory = 25;

    /**
     * No-args constructor.
     */
    public ResourceStore() {
    }

    /**
     * Gets the amount of energy in stock.
     * @return Amount of energy in stock
     */
    public final int getEnergyInventory() {
        return energyInventory;
    }

    /**
     * Removes one energy from the store.
     */
    public final void buyEnergy() {
        int total = getEnergyInventory();
        if (total > 0) {
            energyInventory = total - 1;
        }
    }

    /**
     * Adds one energy to the store.
     */
    public final void addEnergy() {
        energyInventory = energyInventory + 1;
    }

    /**
     * Gets the amount of food in stock.
     * @return Amount of food in stock
     */
    public final int getFoodInventory() {
        return foodInventory;
    }

    /**
     * Removes one food from the store.
     */
    public final void buyFood() {
        int total = getFoodInventory();
        if (total > 0) {
            foodInventory = total - 1;
        }
    }

    /**
     * Adds one food to the store.
     */
    public final void addFood() {
        foodInventory = foodInventory + 1;
    }

    /**
     * Gets the amount of crystite in stock.
     * @return Amount of crystite in stock
     */
    public final int getCrystiteInventory() {
        return crystiteInventory;
    }

    /**
     * Removes one crystite from the store.
     */
    public final void buyCrystite() {
        int total = getCrystiteInventory();
        if (total > 0) {
            crystiteInventory = total - 1;
        }
    }

    /**
     * Adds one crystite to the store.
     */
    public final void addCrystite() {
        crystiteInventory = crystiteInventory + 1;
    }


    //implement this when mules are made to be limited
//    private int getMuleInventory() {
//        return muleInventory;
//    }
//    public void buyMule() {
//        int total = getMuleInventory();
//        if (total > 0) {
//            muleInventory = total - 1;
//        }
//    }
//   public void addMule() {
//       muleInventory = muleInventory + 1;
//   }

    /**
     * Gets the amount of smithore in stock.
     * @return Amount of smithore in stock
     */
    public final int getSmithOreInventory() {
        return smithoreInventory;
    }

    /**
     * Removes one smithore from the store.
     */
    public final void buySmithOre() {
        int total = getSmithOreInventory();
        if (total > 0) {
            smithoreInventory = total - 1;
        }
    }

    /**
     * Adds one smithore to the store.
     */
    public final void addSmithOre() {
        smithoreInventory = smithoreInventory + 1;
    }

    public void clearFoodStock() {
        foodInventory = 0;
    }

    public void clearSmithOreStock() {
        smithoreInventory = 0;
    }

    public void addLumber() {
        lumberInventory = lumberInventory + 1;
    }

    public void buyLumber() {
        int total = getLumberInventory();
        if (total > 0) {
            lumberInventory = total - 1;
        }
    }

    public int getLumberInventory() {
        return lumberInventory;
    }
}
