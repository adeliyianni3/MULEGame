package MULE.models;

//Created by Antonia on 10/2/2015.
/**
 * Resource implementation holding information for a resource.
 */
public class Energy extends Resource {
    /**
     * No-args constructor.
     */
    public Energy() {
        this.setPrice(25);
        this.setStorePriceExtra(50);
        this.setID(0);
    }
    /**
     * Sells one of this Resource from the store, if possible.
     * @param store ResourceStore to be sold to
     */
    @Override
    public final void sellInventory(final ResourceStore store) {
        store.addEnergy();
        //return store.getEnergyInventory();
    }
    /**
     * Gets the amount of this Resource contained in the store.
     * @param store ResourceStore to be checked
     * @return Amount of this Resource contained in the store
     */
    @Override
    public final int getInventory(final ResourceStore store) {
        return store.getEnergyInventory();
    }
    /**
     * Purchases one of this Resource from the store, if possible.
     * @param store ResourceStore to be bought from
     * @return Resulting inventory of this Resource in the store
     */
    @Override
    public final int buyInventory(final ResourceStore store) {
        store.buyEnergy();
        return store.getEnergyInventory();
    }

    @Override
    public final String toString() {
        return "Energy";
    }
    /**
     * Determines the amount of production done based on a given LandType.
     * @param type LandType that is being produced on
     * @return Number of production
     */
    @Override
    public final int produce(final LandType type) {
        return (int) type.getEnergyFactor();
    }
}
