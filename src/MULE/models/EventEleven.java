package MULE.models;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventEleven implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventEleven() {
    }

    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        boolean check = p.loseMule();
        if (check) {
            return p.getName() + " WILD QI'ZOZIVUNS SCARED ONE OF YOUR "
                    + " MULES AWAY.";
        } else {
            return p.getName() + " WILD QI'ZOZIVUNS ATTACKED "
                    + " HOWEVER YOU HAD NO MULE TO SCARE AWAY.";
        }
    }
}
