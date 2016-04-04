package logic.gameComponents.boardComponents.gObject.list;

import logic.gameComponents.GList;


/**
 * Интерфейс для удобного хранения GObjectAbstract.
 */
public interface ListGObject<GObject> extends GList<GObject> {
    /**
     * Добавить новый gObject.
     * @param gObject который нужно добавить.
     * @return false если добавить не получилось или массив переполнен.
     */
     boolean add(GObject gObject);
    /**
     * Получить GObjectAbstract по id.
     * @param id уникальный идентификатор GObjectAbstract.
     * @return GObjectAbstract соответствующий id.
     * null если id не соответствует не одному GObjectAbstract.
     */
     GObject get(int id);
    /**
     * Получить количество GObjectAbstract.
     * @return количество GObjectAbstract находящихся в ListGObject.
     */
     int size();
}
