package MULE.models;

// Created by Antonia on 10/2/2015.
/**
 * Resource implementation holding information for a resource.
 */
public class Food extends Resource {
    private static final int PRICE = 30;
    private static final int EXTRAPRICE = 25;
    private static final int ID = 1;
    /**
     * No-args constructor.
     */
    public Food() {
        this.setPrice(PRICE);
        this.setStorePriceExtra(EXTRAPRICE);
        this.setID(ID);
    }
    /**
     * Sells one of this Resource from the store, if possible.
     * @param store ResourceStore to be sold to
     */
    @Override
    public final void sellInventory(final ResourceStore store) {
        store.addFood();
        //return store.getFoodInventory();
    }
    /**
     * Gets the amount of this Resource contained in the store.
     * @param store ResourceStore to be checked
     * @return Amount of this Resource contained in the store
     */
    @Override
    public final int getInventory(final ResourceStore store) {
        return store.getFoodInventory();
    }
    /**
     * Purchases one of this Resource from the store, if possible.
     * @param store ResourceStore to be bought from
     * @return Resulting inventory of this Resource in the store
     */
    @Override
    public final int buyInventory(final ResourceStore store) {
        store.buyFood();
        return store.getFoodInventory();
    }

    @Override
    public final String toString() {
        return "Food";
    }
    /**
     * Determines the amount of production done based on a given LandType.
     * @param type LandType that is being produced on
     * @return Number of production
     */
    @Override
    public final int produce(final LandType type) {
        return (int) type.getFoodFactor();
    }
}
