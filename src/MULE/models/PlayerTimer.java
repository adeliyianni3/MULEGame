package MULE.models;

/**
 * Created by Antonia on 9/24/2015.
 */

//This is what I got so far. It should work but I can only check
// at 5 pm. Anyone else who sees this, try it out :)
import MULE.controllers.ScreenNavigator;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

import static MULE.models.Game.endTurn;
import static MULE.models.Game.players;

public class PlayerTimer {
    static int secs;
    static Timer timer;
    static MyTask runner;

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
        timer.cancel();
        System.out.println("TurnEnds");
        endTurn();
        if (Game.currentState != Game.State.MAP) {
            Game.changeState(Game.State.MAP);
            ScreenNavigator.instance.loadMap();
        }
    }
    public int getTime() {
        return secs;
    }
    private int setInterval() {
        if (secs == 1) {
            //Platform.runLater(runner);
            timer.cancel();
            System.out.println("TurnEnds");
            endTurn();
        }
        return --secs;
    }
}
