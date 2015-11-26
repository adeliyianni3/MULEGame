package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventTen implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventTen() {
    }

    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        p.addResource(new Crystite(), 3);
        return p.getName() + " YOU DISCOVERED AN ABANDONED SPACE CRAFT "
                + " AND INSIDE HAD 3 CRYSTITES.";
    }
}
