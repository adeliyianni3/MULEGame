package MULE.models;

//Created by Antonia on 11/4/2015.
public class Buzzite implements Race {
    private final int startMoney;
    public Buzzite() {startMoney = 1000;}

    @Override
    public int startMoney() {
        return startMoney;
    }
}
