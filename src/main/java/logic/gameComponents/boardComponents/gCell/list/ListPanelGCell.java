package logic.gameComponents.boardComponents.gCell.list;

import logic.gameComponents.GList;

/**
 * Интерфейс для удобного хранения GCell.
 */
public abstract class ListPanelGCell<GCell> extends GList<GCell>{


    /**
     * Добавляет GCell в список.
     * @param gCell который нужно добавить.
     * @return true если GCell был добавлен.
     */
     abstract public boolean add(GCell gCell);

    /**
     * Получить GCell по координатам.
     * @param x колонка в которой находится GCell.
     * @param y строка в которой находится GCell.
     * @return GCell который находится в заданной строке и линии.
     * Null если по заданным параметрам нету GCell.
     */
    abstract public GCell get(int x, int y);

    /**
     * Установить GCell на заданную колонку и линию.
     * @param gCell который нужно установить.
     * @param x колонка в которой нужно установить GCell.
     * @param y строка в которой нужно установить GCell.
     */
    abstract public void set(GCell gCell, int x, int y);

    /**
     * Максимум GCell по x.
     * @return максимум GCell по x.
     */
    abstract public int getMaxX();
    /**
     * Максимум GCell по y.
     * @return максимум GCell по y.
     */
    abstract public int getMaxY();
    
}
