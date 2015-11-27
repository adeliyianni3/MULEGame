package MULE.models;

import MULE.controllers.Game;
import MULE.controllers.MapController;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

// Created by Ethan on 9/17/2015.

/**
 * Class holding information about a Player playing MULE.
 */
public class Player {
    /**
     * Name of the Player.
     */
    private String name;
    /**
     * Race of the Player.
     */
    private Race race;
    /**
     * Color of the Player.
     */
    private Color color;
    /**
     * Mule that the Player is holding, null if not holding one.
     */
    private Mule mule;
    /**
     * Amount of money the Player has.
     */
    private int money;
    /**
     * Array of amounts of Resources that the Player owns.
     */
    private int[] numOfResources; //energy, food, smithore, and crystite
    /**
     * Number of Lands that the Player owns.
     */
    private int numOfLands;
    /**
     * ArrayList of Land owned by the Player.
     */
    private final ArrayList<Land> landOwned = new ArrayList<>();

    /**
     * Gets and takes away the Mule that the Player is holding.
     * @return Mule that the Player was holding
     */
    public final Mule getMule() {
        Mule temp = mule;
        mule = null;
        return temp;
    }

    /**
     * Gives the Player a Land.
     * @param land Land to be given to the Player
     */
    public final void addLand(final Land land) {
        System.out.println("HERE");
        landOwned.add(land);
    }

    /**
     * Gets a list of Land owned by the Player.
     * @return A list of Land owned by the Player
     */
    public final ArrayList<Land> getLand() {
        return landOwned;
    }

    /**
     * Gets the number of Energy that the Player has.
     * @return The number of Energy that the Player has.
     */
    public final int getEnergy() {
        return numOfResources[0];
    }

    /**
     * Checks to see if the Player has any energy.
     * @return true if the Player has at least one energy, false otherwise
     */
    public final boolean hasEnergy() {
        return numOfResources[0] > 0;
    }

    /**
     * Gets the number of Food that the Player has.
     * @return The number of Food that the Player has.
     */
    public final int getFood() {
        return numOfResources[1];
    }

    /**
     * Gets the number of Lands that the Player has.
     * @return The number of Land that the Player has.
     */
    public final int getNumOfLands() {
        return numOfLands;
    }

    /**
     * Gets the number of Smithore that the Player has.
     * @return The number of Smithore that the Player has.
     */
    public final int getSmithore() {
        return numOfResources[2];
    }

//    public int getCrystite() {
//        return numOfResources[3];
//    }

    /**
     * Gives the player a Mule to hold.
     * @param newMule Mule to be held
     */
    public final void giveMule(final Mule newMule) {
        mule = newMule;
    }

//    public void sellLand() {
//        //TODO
//    }

    /**
     * No-args constructor.
     */
    public Player() {

    }

    /**
     * Constructor.
     * @param newName Name of the player
     * @param sRace Race of the player
     * @param newColor Color of the player
     */
    public Player(final String newName, final String sRace,
                  final Color newColor) {
        name = newName;
        try {
            String newsRace = sRace.substring(0, 1).toUpperCase()
                    + sRace.substring(1);
            Class<?> c = Class.forName("MULE.models." + newsRace);
            this.race = (Race) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        color = newColor;
        money = race.startMoney();

        numOfLands = 0;
        numOfResources = new int[4];

        for (int i = 0; i < 4; i = i + 1) {
            Energy resource = new Energy();
            addResource(resource);
        }
        for (int i = 0; i < 8; i = i + 1) {
            Food resource = new Food();
            addResource(resource);
        }

    }

    /**
     * Increases the amount of lands owned by the Player by one.
     */
    public final void incrementLand() {
        numOfLands++;
    }
    public final void decrementLand() {
        Random rand = new Random();
        int index = rand.nextInt(numOfLands);
        numOfLands--;
        Land lostland = landOwned.get(index);
        landOwned.remove(lostland);
        lostland.uncolor();
        lostland.removeMule();
    }
    public final void loseLand() {
        if(numOfLands > 0) {
            decrementLand();
        }
    }
    public final boolean loseMule() {
        if(numOfLands > 0) {
            ArrayList<Land> land = landOwned;
            int count = 0;
            while (count < numOfLands) {
                if (land.get(count).hasMule()) {
                    land.get(count).removeMule();
                    MapController.loseMule(land.get(count).getRow(), land.get(count).getCol());
                    return true;
                }
                else {
                    count++;
                }
            }
        }
        return false;
    }
    /**
     * Gets the name of the Player.
     * @return The name of the Player
     */
    public final String getName() {
        return name;
    }

    /**
     * Adds a Resource to the Player's inventory.
     * @param source Resource to be added
     */
    public final void addResource(final Resource source) {
        numOfResources[source.getID()] = numOfResources[source.getID()] + 1;
    }

    /**
     * Adds a given amount of a certain Resource to the Player's inventory.
     * @param source Resource to be added
     * @param amount Amount of the Resource to be added
     */
    public final void addResource(final Resource source,
                                  final int amount) {
        numOfResources[source.getID()] =
                numOfResources[source.getID()] + amount;
    }

//    public void addFood(int amount) {
//        addResource(new Food(), amount);
//    }
//
//    public void addEnergy(int amount) {
//        addResource(new Energy(), amount);
//    }
//
//    public void addSmithOre(int amount) {
//        addResource(new SmithOre(), amount);
//    }
//
//    public void addCrystite(int amount) {
//        addResource(new Crystite(), amount);
//    }

    /**
     * Gets the amount of Food that the Player has.
     * @return The amount of Food that the Player has
     */
    public final int foodCounter() {
        return numOfResources[1];
    }

    /**
     * Checks to see if the Player has at least one of a given Resource.
     * @param source Resource to be checked
     * @return true if the Player owns at least one of the given Resource,
     *  false otherwise
     */
    public final boolean contains(final Resource source) {
        return numOfResources[source.getID()] > 0;
    }

    /**
     * Removes one of the given Resource from the Player's inventory.
     * @param source Resource to be removed
     */
    public final void removeResource(final Resource source) {
        numOfResources[source.getID()] = numOfResources[source.getID()] - 1;
    }

    /**
     * Removes one energy from the Player's inventory.
     */
    public final void removeEnergy() {
        removeResource(new Energy());
    }

    /**
     * Removes one food from the Player's inventory.
     */
    public final void removeFood() {
        removeResource(new Food());
    }

//    public void removeSmithOre() {
//        removeResource(new SmithOre());
//    }
//
//    public void removeCrystite() {
//        removeResource(new Crystite());
//    }

//    public Race getRace() {
//        return race;
//    }

    /**
     * Gets the Player's Color.
     * @return The Player's Color
     */
    public final Color getColor() {
        return color;
    }

    /**
     * Gives a certain amount of money to the Player.
     * @param amount Amount of money to be added
     */
    public final void addMoney(final int amount) {
        money = money + amount;
    }

    /**
     * Takes away a certain amount of money from the Player.
     * @param amount Amount of money to be removed
     */
    public final void subtractMoney(final int amount) {
        money = money - amount;
    }

    /**
     * Gets the current amount of money.
     * @return Current amount of money
     */
    public final int getMoney() {
        return money;
    }

    /**
     * Calculates the Player's current score.
     * @return The Player's current score
     */
    public final int getScore() {
        int totalScore = 0;
        totalScore += Game.getInstance().moneyValue() * getMoney();
        totalScore += numOfLands
                * Game.getInstance().landValue();
        totalScore += numOfResources[0] * Game.getInstance().energyValue();
        totalScore += numOfResources[1] * Game.getInstance().foodValue(); //food
        totalScore += numOfResources[2]
                * Game.getInstance().smithoreValue(); //smithore
        return totalScore;
    }

    /**
     * Gets the String representation of the Player's info.
     * @return String representation of the Player's info
     */
    public final String toString() {
        return "Player name: " + name + ", race: " + race + ", color: "
                + color + ", money: " + money + ", score: " + getScore();
    }
}
