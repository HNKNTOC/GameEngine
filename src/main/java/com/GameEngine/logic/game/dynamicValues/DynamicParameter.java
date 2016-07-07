package com.GameEngine.logic.game.dynamicValues;

/**
 * Классы реализующие данный интерфейс должны хранить имя атрибута и его значение.
 */
public interface DynamicParameter {
    /**
     * Добавляет новый параметр.
     * @param name  имя параметра.
     * @param value значение параметра.
     */
    void putParameter(String name, String value);

    /**
     * Возвращает параметр по его Имени.
     * @param name имя параметра
     * @return значение которое соответствует параметру.
     *  null если не найдено соответствие.
     */
    String getParameter(String name);

    /**
     * Возвращает параметр по его Имени.
     *
     * @param name имя параметра
     * @return значение которое соответствует параметру.
     * @throws NumberFormatException если не найдено соответствие.
     */
    int getParameterInt(String name) throws NumberFormatException;

    /**
     * Добавляет новый параметр.
     *
     * @param name  имя параметра.
     * @param value значение параметра.
     */
    void putParameterInt(String name, int value);

    /**
     * Возвращает параметр по его Имени.
     *
     * @param name имя параметра
     * @return значение которое соответствует параметру.
     * false если не найдено соответствие.
     */
    boolean getParameterBoolean(String name);

    /**
     * Добавляет новый параметр.
     *
     * @param name  имя параметра.
     * @param value значение параметра.
     */
    void putParameterBoolean(String name, boolean value);
}
