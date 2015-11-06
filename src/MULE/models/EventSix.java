package MULE.models;

//Created by Antonia on 10/23/2015.
/**
 * Event to be acted on a given Player at a random time.
 */
public class EventSix implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventSix() {
    }
    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        int i = p.getFood();
        for (int k = 0; k < i / 2; k = k + 1) {
            p.removeResource(new Food());
        }
        return p.getName() + " MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR "
                + "STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
}
