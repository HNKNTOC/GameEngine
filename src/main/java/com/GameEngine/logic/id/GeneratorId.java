package com.GameEngine.logic.id;

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
