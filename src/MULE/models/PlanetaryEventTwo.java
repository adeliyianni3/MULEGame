package MULE.models;

import MULE.controllers.Game;//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on all given Players at a random time.
 */
public class PlanetaryEventTwo implements RandomEvent {
    /**
     * No-args constructor.
     */
    public PlanetaryEventTwo() {
    }

    @Override
    public String apply(Player p) {
        Game.getInstance().getStore().clearFoodStock();
        return "FIRE IN STORE, ALL FOOD IS LOST.";
    }
}
