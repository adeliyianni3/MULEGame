package MULE.controllers;


import com.google.gson.InstanceCreator;
import javafx.scene.paint.Color;

import java.lang.reflect.Type;

// Created by Ethan on 10/27/2015.
class ColorInstanceCreator implements InstanceCreator<Color> {
    public Color createInstance(Type type) {
        return new Color(0, 0, 0, 0);
    }
}