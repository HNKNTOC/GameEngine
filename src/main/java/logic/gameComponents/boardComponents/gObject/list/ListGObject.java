package logic.gameComponents.boardComponents.gObject.list;

import logic.gameComponents.GList;

import java.util.Observable;
import java.util.Observer;

/**
 * Интерфейс для удобного хранения GObject.
 */
public abstract class ListGObject<GObject> extends GList<GObject> implements Observer {
    /**
     * Добавить новый gObject.
     * @param gObject который нужно добавить.
     * @return false если добавить не получилось или массив переполнен.
     */
    abstract public boolean add(GObject gObject);
    /**
     * Получить GObject по id.
     * @param id уникальный идентификатор GObject.
     * @return GObject соответствующий id.
     * null если id не соответствует не одному GObject.
     */
    abstract public GObject get(int id);
    /**
     * Получить количество GObject.
     * @return количество GObject находящихся в ListGObject.
     */
    abstract public int size();

    @Override
    public void update(Observable o, Object arg) {
        notifyObservers(arg);
    }
}
