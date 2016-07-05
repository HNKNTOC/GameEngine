package com.GameEngine.logic.game.components.gObject.list;

import com.GameEngine.logic.game.components.GList;


/**
 * Интерфейс для удобного хранения GObject.
 */
public interface ListGObject<GObject> extends GList<GObject> {
    /**
     * Добавить новый gObject.
     * @param gObject который нужно добавить.
     * @return false если добавить не получилось или массив переполнен.
     */
     boolean add(GObject gObject);
    /**
     * Получить GObject по id.
     * @param id уникальный идентификатор GObject.
     * @return GObject соответствующий id.
     * null если id не соответствует не одному GObject.
     */
     GObject get(int id);
    /**
     * Получить количество GObject.
     * @return количество GObject находящихся в ListGObject.
     */
     int size();
}
