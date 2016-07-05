package com.GameEngine.logic.game.components.gObject;

import java.util.ArrayList;

/**
 * Фабрика для GObject
 */
public interface FactoryGObject {
    GObject createGObject();

    ArrayList<GObject> createGObject(int number);
}
