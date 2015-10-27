package MULE.models;

import MULE.controllers.Game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Created by Antonia on 10/16/2015.
public interface RandomEvent {
    String apply(Player p);
}
