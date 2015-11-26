package MULE.models;

import MULE.controllers.Game;

import java.util.ArrayList;

//Created by Antonia on 10/23/2015.

/**
 * Event to be acted on a given Player at a random time.
 */
public class EventEight implements RandomEvent {
    /**
     * No-args constructor.
     */
    public EventEight() {
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
        ArrayList<Land> land = p.getLand();
        int count = 0;
        while (count < land.size()) {
            if (land.get(count).hasMule()) {
                count = land.size();
                int m = ROUNDSM[Game.getInstance().getRound() - 3];
                int gain = 5 * m;
                p.addMoney(gain);
                return p.getName() + " YOUR MULE HAS WON AT THE FAIR"
                        + " A PRIZE OF $" + gain + ".";
            } else {
                count++;
            }
        }
        return p.getName() + " YOU HAVE NO MULE"
                + " SO YOU CANNOT ENTER FAIR'S COMPETITION.";
    }
}
