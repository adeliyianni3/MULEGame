package MULE.models;

import MULE.controllers.Game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Created by Antonia on 10/16/2015.
public class RandomEvent {
    private int possibleEvents = 7;
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};

    public String apply(int i, Player p) {
        String result = "Nothing";
        int x = i % possibleEvents;
        if (p == Game.getPlayers()[0] && x > 3) {
            x = i % 4;
        }
        try {
            String name = "event" + x;
            Class[] paramPlayer = new Class[1];
            paramPlayer[0] = Player.class;
            Method method = RandomEvent.class.getMethod(name, paramPlayer);
            result = (String) method.invoke(null, p);
            //throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException
        } catch (NoSuchMethodException e) {
            System.out.println("RANDOM EVENT NOT WORKING2");
        } catch (IllegalAccessException e) {
            System.out.println("RANDOM EVENT NOT WORKING3");
        } catch (InvocationTargetException e) {
            System.out.println("RANDOM EVENT NOT WORKING4");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("RANDOM EVENT NOT WORKING " + e);
        }
        return "In round " + Game.getRound() + ", " + p.getName() + ", \n" + result;
    }
    public static String event0(Player p) {
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Energy());
        p.addResource(new Energy());
        return "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";
    }
    public static String event1(Player p) {
        p.addResource(new SmithOre());
        p.addResource(new SmithOre());
        return "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    }
    public static String event2(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int gain = 8*m;
        p.addMoney(gain);
        return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + gain;
    }
    public static String event3(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int gain = 2*m;
        p.addMoney(gain);
        return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + gain;
    }
    public static String event4(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int lose = 4*m;
        p.subtractMoney(lose);
        return "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + lose;
    }
    public static String event5(Player p) {
        int i = p.getFood();
        for (int k = 0; k < i/2; k = k + 1) {
            p.removeResource(new Food());
        }
        return "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
    public static String event6(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int lose = 6*m;
        p.subtractMoney(lose);
        return "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU " + lose + " TO CLEAN IT UP.";
    }
}
