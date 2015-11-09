package MULE.models;

import MULE.controllers.Game;

//Created by Antonia on 10/23/2015.
/**
 * Event to be acted on a given Player at a random time.
 */
public class EventFour implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventFour() {
    }

    /**
     * Values associated with different rounds.
     */
    private static final int[] ROUNDSM =
            {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
    /**
     * Applies the random event to the given Player.
     * @param p Player experiencing the event
     * @return Message describing the event
     */
    @Override
    public final String apply(final Player p) {
        int m = ROUNDSM[Game.getInstance().getRound() - 3];
        int gain = 2 * m;
        p.addMoney(gain);
        return p.getName() + " YOU FOUND A DEAD MOOSE "
                + "RAT AND SOLD THE HIDE FOR $" + gain;
    }
}
