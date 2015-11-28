package MULE.models;

// Created by Antonia on 10/2/2015.
/**
 * Resource implementation holding information for a resource.
 */
public class Oil extends Resource {
    private static final int PRICE = 15;
    private static final int EXTRAPRICE = 40;
    private static final int ID = 5;
    /**
     * No-args constructor.
     */
    public Oil() {
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
        store.addOil();
        //return store.getOilInventory();
    }
    /**
     * Gets the amount of this Resource contained in the store.
     * @param store ResourceStore to be checked
     * @return Amount of this Resource contained in the store
     */
    @Override
    public final int getInventory(final ResourceStore store) {
        return store.getOilInventory();
    }
    /**
     * Purchases one of this Resource from the store, if possible.
     * @param store ResourceStore to be bought from
     * @return Resulting inventory of this Resource in the store
     */
    @Override
    public final int buyInventory(final ResourceStore store) {
        store.buyOil();
        return store.getOilInventory();
    }

    @Override
    public final String toString() {
        return "Oil";
    }
    /**
     * Determines the amount of production done based on a given LandType.
     * @param type LandType that is being produced on
     * @return Number of production
     */
    @Override
    public final int produce(final LandType type) {
        return (int) type.getOilFactor();
    }
}
