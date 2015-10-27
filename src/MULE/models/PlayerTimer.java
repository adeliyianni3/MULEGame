package MULE.models;

// Created by Antonia on 9/24/2015.

//This is what I got so far. It should work but I can only check
// at 5 pm. Anyone else who sees this, try it out :)
import MULE.controllers.Game;
import MULE.controllers.ScreenNavigator;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

import static MULE.controllers.Game.currentState;
import static MULE.controllers.Game.endTurn;

public class PlayerTimer {
    static int secs;
    static Timer timer;
    static int[] foodNeeded = {3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};

    private int computeTime(){
        Player p = Game.instance.players[Game.instance.getTurn() - 1];
        int food = p.foodCounter();
        System.out.println(food);
        if (food > 0 && food < foodNeeded[Game.instance.getRound() - 3]) {
            return 30;
        } else if (food == 0) {
            return 5;
        } else {
            return 50;
        }
    }
    public void startTime() {
        secs = computeTime();
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
        timer.cancel();
        System.out.println("TurnEnds");
        endTurn();
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
    private int setInterval() {
        if (secs == 1) {
            if (currentState != Game.State.MAP) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenNavigator.instance.loadMap();
                    }
                });
                Game.instance.changeState(Game.State.MAP);
            }
            timer.cancel();
            System.out.println("TurnEnds");
            endTurn();
        }
        return --secs;
    }
}
