package MULE.models;

// Created by Antonia on 9/24/2015.

//This is what I got so far. It should work but I can only check
// at 5 pm. Anyone else who sees this, try it out :)
import MULE.controllers.Game;
import MULE.controllers.ScreenNavigator;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;


public class PlayerTimer {
    public PlayerTimer(){}
    private int secs;
    private static Timer timer;
    private final int[] foodNeeded = {3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};

    public int computeTime(Player p, int round){
        int food = p.foodCounter();
        if (food > 0 && food < foodNeeded[round - 3]) {
            return 30;
        } else if (food == 0) {
            return 5;
        } else {
            return 50;
        }
    }

    public void startTime() {
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
    public void stopTime() {
        if (timer == null) {
            timer = new Timer();
        }
        timer.cancel();
        System.out.println("TurnEnds");
        Game.instance.endTurn();
        if (Game.instance.currentState != Game.State.MAP) {
            Game.instance.changeState(Game.State.MAP);
            ScreenNavigator.instance.loadMap();
        }
        if (Game.instance.getRound() > 14) {
            ScreenNavigator.instance.loadEndGame();
        }
    }
    public int getTime() {
        return secs;
    }
    private void setInterval() {
        if (secs == 1) {
            if (Game.instance.currentState != Game.State.MAP) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenNavigator.instance.loadMap();
                    }
                });
                Game.instance.changeState(Game.State.MAP);
            }
            if (timer == null) {
                timer = new Timer();
            }
            timer.cancel();
            System.out.println("TurnEnds");
            Game.instance.endTurn();
        }
        //return --secs;
    }
}
