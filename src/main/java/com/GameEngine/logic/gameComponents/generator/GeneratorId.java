package com.GameEngine.logic.gameComponents.generator;

/**
 * Генирирует id.
 */
public class GeneratorId {
    private static int ID;

    public static int generateId(){
        ID++;
        return ID;
    }
}
