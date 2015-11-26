package MULE.models;

//Created by Antonia on 10/23/2015.

import java.util.Random;

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventTwelve implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventTwelve() {
    }

    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        boolean check = p.hasEnergy();
        if (check) {
            int x = new Random().nextInt(p.getEnergy());
            for (int k = 0; k < x / 2; k = k + 1) {
                p.removeResource(new Energy());
            }
            return p.getName() + " WILD T'VOAS STOLE"
                    + x + "PIECES OF ENERGY.";
        } else {
            return p.getName() + " WILD T'VOAS CAME TO STEAL"
                    + " ENERGY, BUT FOUND NONE.";
        }
    }
}
