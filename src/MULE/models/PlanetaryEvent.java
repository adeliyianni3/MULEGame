package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on all given Players at a random time.
 */
public abstract class PlanetaryEvent implements RandomEvent {
    /**
     * No-args constructor.
     */
    public PlanetaryEvent() {
    }
    public final String apply() {
        return null;
    }
}
