package com.GameEngine.logic.dynamicValues;

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
     * null если не найдено соответствие.
     */
    int getParameterInt(String name);

    /**
     * Добавляет новый параметр.
     *
     * @param name  имя параметра.
     * @param value значение параметра.
     */
    void putParameterInt(String name, int value);
}
