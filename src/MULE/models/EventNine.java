package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventNine implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventNine() {
    }

    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        p.loseLand();
        return p.getName() + " YOUR DEED WAS MISFILED DUE TO "
                + " CLERICAL ERROR, A LAND PIECE WAS LOST.";
    }
}
