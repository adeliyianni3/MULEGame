package MULE.models;

// Created by Antonia on 10/2/2015.
/**
 * Resource implementation holding information for a resource.
 */
public class SmithOre extends Resource {
    private static final int PRICE = 50;
    private static final int EXTRAPRICE = 75;
    private static final int ID = 2;
    /**
     * No-args constructor.
     */
    public SmithOre() {
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
        store.addSmithOre();
        //return store.getSmithOreInventory();
    }
    /**
     * Gets the amount of this Resource contained in the store.
     * @param store ResourceStore to be checked
     * @return Amount of this Resource contained in the store
     */
    @Override
    public final int getInventory(final ResourceStore store) {
        return store.getSmithOreInventory();
    }
    /**
     * Purchases one of this Resource from the store, if possible.
     * @param store ResourceStore to be bought from
     * @return Resulting inventory of this Resource in the store
     */
    @Override
    public final int buyInventory(final ResourceStore store) {
        store.buySmithOre();
        return store.getSmithOreInventory();
    }

    @Override
    public final String toString() {
        return "SmithOre";
    }
    /**
     * Determines the amount of production done based on a given LandType.
     * @param type LandType that is being produced on
     * @return Number of production
     */
    @Override
    public final int produce(final LandType type) {
        return (int) type.getSmithOreFactor();
    }
}
