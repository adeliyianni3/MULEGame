package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventTwo implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventTwo() {
    }
    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
            p.addResource(new SmithOre());
            p.addResource(new SmithOre());
            return p.getName() + " A WANDERING TECH STUDENT REPAID YOUR "
                    + "HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    }
}
