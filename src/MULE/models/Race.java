package MULE.models;

// Created by Aaron on 9/17/2015.
public enum Race {
    UGAITE(1000),
    BUZZITE(1000),
    HUMANOID(600),
    FLAPPER(1600),
    BONZOID(1000);

    private int startmoney;
    Race(int startmoney) {
        this.startmoney = startmoney;
    }
    public int startMoney() {
        return startmoney;
    }
}
