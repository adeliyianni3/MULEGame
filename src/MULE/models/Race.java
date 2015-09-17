package MULE.models;

/**
 * Created by Aaron on 9/17/2015.
 */
public enum Race {
    PACKER(0.8,1.2),
    SHEROID(0.9,1.1),
    HUMANOID(1.0,1.0),
    LEGGITE(1.1,0.9),
    FLAPPER(0.7,1.3),
    BONZOID(1.2,0.8),
    MECHTRON(1.3,0.7),
    GOLLUMER(0.6,1.4),;

    private double speed;
    private double luck;

    private Race(double speed, double luck) {
        this.speed = speed;
        this.luck = luck;
    }
    public double speed() {
        return speed;
    }
    public double luck() {
        return luck;
    }
}
