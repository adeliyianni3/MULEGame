package MULE.models;

import MULE.controllers.Game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Antonia on 10/16/2015.
 */
public class RandomEvent {
    private int possibleEvents = 7;
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};

    public void apply(int i, Player p) {
        int x = i % possibleEvents;
        if (p == Game.getPlayers()[0] && x > 3) {
            x = i % 4;
        }
        try {
            String name = "event" + x;
            Class[] paramPlayer = new Class[1];
            paramPlayer[0] = Player.class;
            Method method = RandomEvent.class.getMethod(name, paramPlayer);
            method.invoke(null, p);
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
    }
    public static void event0(Player p) {
        System.out.println("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Food());
        p.addResource(new Energy());
        p.addResource(new Energy());
    }
    public static void event1(Player p) {
        System.out.println("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
        p.addResource(new SmithOre());
        p.addResource(new SmithOre());
    }
    public static void event2(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int gain = 8*m;
        System.out.println("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + gain);
        p.addMoney(gain);
    }
    public static void event3(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int gain = 2*m;
        System.out.println("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + gain);
        p.addMoney(gain);
    }
    public static void event4(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int lose = 4*m;
        System.out.println("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + lose);
        p.subtractMoney(lose);
    }
    public static void event5(Player p) {
        System.out.println("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
        int i = p.getFood();
        for (int k = 0; k < i/2; k = k + 1) {
            p.removeResource(new Food());
        }
    }
    public static void event6(Player p) {
        int m = roundsM[Game.getRound() - 3];
        int lose = 6*m;
        System.out.println("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU " + lose + " TO CLEAN IT UP.");
        p.subtractMoney(lose);
    }
}
