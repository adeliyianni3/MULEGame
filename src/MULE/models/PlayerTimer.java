package MULE.models;

/**
 * Created by Antonia on 9/24/2015.
 */

//This is what I got so far. It should work but I can only check
// at 5 pm. Anyone else who sees this, try it out :)
import java.util.Timer;
import java.util.TimerTask;

import static MULE.models.Game.endTurn;

public class PlayerTimer {
    static int secs;
    static Timer timer;

    public void startTime() {
        secs = 50;
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        System.out.println("Turn Starts");
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();

            }
        }, delay, period);
    }
    public void stopTime() {
        endTurn();
        timer.cancel();
    }
    public int getTime() {
        return secs;
    }
    private int setInterval() {
        if (secs == 1) {
            timer.cancel();
            endTurn();
            System.out.println("TurnEnds");
        }
        return --secs;
    }
}
