package com.GameEngine.logic.game.id;

/**
 * Генирирует id для GComponents.
 */
public class GeneratorId {
    private static int ID;

    public static int generateId(){
        ID++;
        return ID;
    }
}
