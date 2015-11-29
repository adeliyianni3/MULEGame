package MULE.models;

// Created by Antonia on 9/24/2015.

//This is what I got so far. It should work but I can only check
// at 5 pm. Anyone else who sees this, try it out :)
import MULE.controllers.Game;
import MULE.controllers.ScreenNavigator;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Helper class wrapping a timer to keep track of game flow.
 */
public class PlayerTimer {
    /**
     * No-args constructor.
     */
    public PlayerTimer() {
    }

    /**
     * Seconds remaining in timer.
     */
    private int secs;
    /**
     * Java Timer performing the back-end stuff.
     */
    private static Timer timer;
    /**
     * Array indicating the amount of food needed to survive each round.
     */
    private final int[] foodNeeded = {3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};

    /**
     * Determines the amount of time remaining for
     *  the player based on their food.
     * @param p Player who is taking their turn
     * @param round Current round number
     * @return Time the Player has to take their turn
     */
    public final int computeTime(final Player p, final int round) {
        int food = p.foodCounter();
        if (food > 0 && food < foodNeeded[round - 3]) {
            return 30;
        } else if (food == 0) {
            return 5;
        } else {
            return 50;
        }
    }

    /**
     * Starts the timer over for the next player.
     */
    public final void startTime() {
        secs = computeTime(Game.instance.players[Game.instance.getTurn() - 1],
                Game.instance.getRound());
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        System.out.println("Turn Starts");
        Game.instance.randomEvent();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();
            }
        }, delay, period);
    }

    /**
     * Stops the timer.
     */
    public final void stopTime() {
        if (timer == null) {
            timer = new Timer();
        }
        timer.cancel();
        System.out.println("TurnEnds");
        Game.instance.endTurn();
        if (Game.instance.getCurrentState() != Game.State.MAP) {
            Game.instance.changeState(Game.State.MAP);
            ScreenNavigator.getInstance().loadMap();
        }
        if (Game.instance.players[Game.instance.getTurn() - 1].anyBroken()) {
            ScreenNavigator.getInstance().loadMuleFix();
        }
        if (Game.instance.getRound() > 14) {
            ScreenNavigator.getInstance().loadEndGame();
        }
    }

    /**
     * Gets the amount of time remaining in the timer.
     * @return Amount of time remaining in the timer
     */
    public final int getTime() {
        return secs;
    }

    /**
     * Sets the interval of the timer.
     */
    private void setInterval() {
        if (secs == 1) {
            if (Game.instance.getCurrentState() != Game.State.MAP) {
                Platform.runLater(() -> ScreenNavigator.getInstance()
                        .loadMap());
                Game.instance.changeState(Game.State.MAP);
            }
            if (timer == null) {
                timer = new Timer();
            }
            timer.cancel();
            System.out.println("TurnEnds");
            Game.instance.endTurn();
        }
        --secs;
    }
}
