package MULE.controllers;


import com.google.gson.InstanceCreator;
import javafx.scene.paint.Color;

import java.lang.reflect.Type;

// Created by Ethan on 10/27/2015.

/**
 * No-args constructor wrapper for the Color class to allow gson implementation.
 */
class ColorInstanceCreator implements InstanceCreator<Color> {
    /**
     * Creates a Color instance based on the provided type.
     * @param type Type to convert to Color.
     * @return Arbitrary Color instance.
     */
    public Color createInstance(final Type type) {
        return new Color(0, 0, 0, 0);
    }
}
