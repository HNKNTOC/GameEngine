package logic.gameComponents.boardComponents.gCell.list;


import logic.gameComponents.boardComponents.gCell.GCell;

import java.util.*;

/**
 * Обертка для LinkedHashMap.
 * Хранит в себе GCell в порядке добавления.
 */
public class HashMapPanelGCell implements ListGCell<GCell> {
    private LinkedHashMap<String,GCell> mapGCell;

    private int x;
    private int y;

    private int maxX;
    private int maxY;

    public HashMapPanelGCell(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        mapGCell = new LinkedHashMap<>(maxX*maxY);
    }

    /**
     * Проверяет заполнен ли массив.
     * @return false если массив заполнен.
     */
    protected boolean checkSize() {
        return (y <= maxY & x <= maxX);
    }

    private String getKey(int x,int y){
        return x+";"+y;
    }

    /**
     * Перемещение на следующею координату.
     */
    protected void increaseSize() {
        x++;
        if (x >= maxX) {
            x = 0;
            y++;
        }
    }

    @Override
    public boolean add(GCell gCell) {
        if (checkSize()) {
            mapGCell.put(getKey(x,y),gCell);

            gCell.setX(x);
            gCell.setY(y);

            increaseSize();
            return true;
        }
        return false;
    }

    @Override
    public void set(GCell gCell, int x, int y) {
        mapGCell.put(getKey(x,y),gCell);
    }

    @Override
    public int getMaxX() {
        return maxX;
    }

    @Override
    public int getMaxY() {
        return maxY;
    }

    @Override
    public GCell get(int x, int y) {
        return mapGCell.get(getKey(x,y));
    }

    @Override
    public int size() {
        return mapGCell.values().size();
    }

    @Override
    public Iterator<GCell> iterator() {
        return mapGCell.values().iterator();
    }
}
