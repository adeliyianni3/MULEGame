package MULE.models;

//Created by TEAM on 9/22/2015.

/**
 * Interface holding information for various resources.
 */
public abstract class Resource {
    /**
     * Price of the resource in the store.
     */
    private int price = 0;
    /**
     * Extra price for a MULE of the given resource type.
     */
    private int storePriceExtra = 0;
    /**
     * ID number of the resource.
     */
    private int id = 0;

    /**
     * No-args contructor.
     */
    public Resource() {
    }

    /**
     * Setter for price.
     * @param newPrice Price value to be set
     */
    final void setPrice(int newPrice) {
        price = newPrice;
    }

    /**
     * Setter for storePriceExtra.
     * @param newStorePriceExtra StorePriceExtra to be set
     */
    final void setStorePriceExtra(int newStorePriceExtra) {
        storePriceExtra = newStorePriceExtra;
    }

    /**
     * Setter for ID.
     * @param newID ID to be set
     */
    final void setID(int newID) {
        id = newID;
    }
    /**
     * Gets the price of this Resource.
     * @return The price of this Resource
     */
    public final int getPrice() {
        return price;
    }

    /**
     * Gets the extra cost added to a Mule of this Resource type.
     * @return The extra cost added to a Mule of this Resource type.
     */
    public final int getStorePriceExtra() {
        return storePriceExtra;
    }

    /**
     * Gets the ID number of this Resource.
     * @return The ID number of this Resource.
     */
    public final int getID() {
        return id;
    }

    /**
     * Gets the amount of this Resource contained in the store.
     * @param store ResourceStore to be checked
     * @return Amount of this Resource contained in the store
     */
    public abstract int getInventory(ResourceStore store);

    /**
     * Purchases one of this Resource from the store, if possible.
     * @param store ResourceStore to be bought from
     * @return Resulting inventory of this Resource in the store
     */
    public abstract int buyInventory(ResourceStore store);

    /**
     * Sells one of this Resource from the store, if possible.
     * @param store ResourceStore to be sold to
     */
    public abstract void sellInventory(ResourceStore store);

    /**
     * Determines the amount of production done based on a given LandType.
     * @param type LandType that is being produced on
     * @return Number of production
     */
    public abstract int produce(LandType type);
}
