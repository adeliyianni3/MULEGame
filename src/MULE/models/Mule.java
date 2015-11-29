package MULE.models;

// Created by Antonia on 9/17/2015.

import MULE.controllers.MapController;

/**
 * Mule class holding information about it's production.
 */
public class Mule {
    /**
     * Resource that this Mule can harvest.
     */
    private final Resource resource;
    private int oil = 4;

    /**
     * No-args constructor.
     */
    public Mule() { //need a no-args constructor for gson to save
        this.resource = null;
    }

    /**
     * Constructor setting the Mule's harvesting Resource.
     * @param newResource Resource that this Mule can harvest
     */
    public Mule(final Resource newResource) {
        resource = newResource;
    }

    /**
     * Gets the Resource type that this Mule can harvest.
     * @return Resource type that this Mule can harvest
     */
    public final Resource getResource() {
        return resource;
    }

    /**
     * Produces its resource based on the given landtype.
     * @param type LandType that this Mule is harvesting on
     * @return Amount of this Mule's resource that was harvested
     */
    public final int produce(final LandType type) {
        useOil();
        return resource.produce(type);
    }

    public void useOil() {
        oil = oil - 1;
    }
    public boolean muleIsBroken() {
        if (oil == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void fixMule() {
        oil = 2;
    }
}
