package com.GameEngine.logic.dynamicValues;

/**
 * Реализация данного интерфейса позволяет классу иметь динамические данные.
 */
public interface Dynamic {
    /**
     * Возврашает класс в который можно добавить новые данные.
     *
     * @return DynamicParameter.
     */
    DynamicParameter<String, String> getDynamicValues();
}
