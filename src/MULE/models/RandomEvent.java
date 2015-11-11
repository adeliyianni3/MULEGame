package MULE.models;


// Created by Antonia on 10/16/2015.

/**
 * Interface executing a predetermined event on a given Player.
 */
public interface RandomEvent {
    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    String apply(Player p);
}
