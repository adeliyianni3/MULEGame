package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventOne implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventOne() {
    }
    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Energy());
        p.addResource(new Energy());
        return p.getName() + " YOU JUST RECEIVED A PACKAGE FROM THE "
                + "GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";
    }
}
