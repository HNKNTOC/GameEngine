package logic.gameComponents.boardComponents.list;

import logic.gameComponents.gCell.GCell;

import java.util.Iterator;

/**
 * Интерфейс для удобного хранения GCell.
 */
public interface ListGCell {
    /**
     * Добавить новый gCell
     * @param gCell который нужно добавить.
     * @return false если добавить не получилось или массив переполнен.
     */
    boolean add(GCell gCell);

    /**
     * Получить GCell.
     * @param x колонка в которой находится GCell.
     * @param y строка в которой находится GCell.
     * @return GCell который находится в заданной строке и линии.
     * Null если по заданным параметрам нету GCell.
     */
    GCell get(int x, int y);

    /**
     * Установить GCell на заданную колонку и линию.
     * @param gCell который нужно установить.
     * @param x колонка в которой нужно установить GCell.
     * @param y строка в которой нужно установить GCell.
     */
    void set(GCell gCell, int x, int y);

    /**
     * Получить количество GCell.
     * @return количество GCell находящихся в ManagerGCell.
     */
    int size();

    int getMaxX();

    int getMaxY();

    Iterator<GCell> getIterator();
}
