package com.GameEngine.logic.dynamicValues;

/**
 * Классы реализующие данный интерфейс должны хранить имя атрибута и его значение.
 *
 * @param <String> Имя параметра.
 * @param <V>      значение параметра.
 */
public interface DynamicParameter<String, V> {
    /**
     * Добавляет новый параметр.
     *
     * @param name  имя параметра.
     * @param value значение параметра.
     */
    void putParameter(String name, V value);

    /**
     * Возвращает параметр по его Имени.
     *
     * @param name имя параметра
     * @return значение которое соответствует параметру.
     *  null если не найдено соответствие.
     */
    V getParameter(String name);
}
