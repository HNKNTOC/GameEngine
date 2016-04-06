package com.GameEngine.logic.gameComponents.boardComponents.gCell.list;

import com.GameEngine.logic.gameComponents.GList;

/**
 * Интерфейс для удобного хранения GCellDefault.
 */
public interface ListGCell<GCell> extends GList<GCell>{


    /**
     * Добавляет GCellDefault в список.
     * @param gCell который нужно добавить.
     * @return true если GCellDefault был добавлен.
     */
      boolean add(GCell gCell);

    /**
     * Получить GCellDefault по координатам.
     * @param x колонка в которой находится GCellDefault.
     * @param y строка в которой находится GCellDefault.
     * @return GCellDefault который находится в заданной строке и линии.
     * Null если по заданным параметрам нету GCellDefault.
     */
     GCell get(int x, int y);

    /**
     * Установить GCellDefault на заданную колонку и линию.
     * @param gCell который нужно установить.
     * @param x колонка в которой нужно установить GCellDefault.
     * @param y строка в которой нужно установить GCellDefault.
     */
     void set(GCell gCell, int x, int y);

    /**
     * Максимум GCellDefault по x.
     * @return максимум GCellDefault по x.
     */
     int getMaxX();
    /**
     * Максимум GCellDefault по y.
     * @return максимум GCellDefault по y.
     */
     int getMaxY();
    
}
