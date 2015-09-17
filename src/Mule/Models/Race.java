package Mule.Models;

/**
 * Created by Aaron on 9/16/2015.
 */
public enum Race {
    PACKER(.8, 1.2, "Packer"),
    SHEROID(1.3, 0.7, "Sheroid"),
    HUMANOID(1.0, 1.0, "Humanoid"),
    LEGGITE(0.7, 1.3, "Leggite"),
    FLAPPER(1.4, 0.6, "Flapper"),
    BONZOID(1.2, 0.8, "Bonzoid"),
    MECHTRON(1.1, 0.9, "Mechtron"),
    GOLLUMER(0.9, 1.1, "Gollumer");

    private double speed;
    private double luck;
    private String name;

    Race(double speed, double luck, String name) {
        this.speed = speed;
        this.luck = luck;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getLuck() {
        return luck;
    }

}
