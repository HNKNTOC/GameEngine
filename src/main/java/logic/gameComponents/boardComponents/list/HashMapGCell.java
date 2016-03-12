package logic.gameComponents.boardComponents.list;

import logic.gameComponents.boardComponents.GBoard;
import logic.gameComponents.gCell.GCell;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by Nikita on 16.02.2016.
 */
public class HashMapGCell implements ListGCell {

    private LinkedHashMap<String,GCell> listGCell;
    protected GBoard gBoard;

    private int x;
    private int y;

    private int maxX;
    private int maxY;

    public HashMapGCell(int x, int y, GBoard gBoard) {
        this.maxX = x;
        this.maxY = y;
        this.gBoard = gBoard;
        listGCell = new LinkedHashMap<>(x*y);
    }

    @Override
    public boolean add(GCell gCell){
        if (checkSize()) {
            listGCell.put(getKey(x,y),gCell);

            gCell.setX(x);
            gCell.setY(y);

            increaseSize();
            gBoard.update();
            return true;
        }
        return false;
    }

    @Override
    public GCell get(int x, int y){
        return listGCell.get(getKey(x,y));
    }

    @Override
    public void set(GCell gCell, int x, int y) {
        listGCell.put(getKey(x,y),gCell);
        gBoard.update();
    }

    @Override
    public int size() {
        return listGCell.size();
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
    public Iterator<GCell> getIterator() {
        return listGCell.values().iterator();
    }

    /**
     * Проверяет заполнен ли массив.
     * @return false если массив заполнен.
     */
    protected boolean checkSize() {
        return (y <= maxY & x <= maxX);
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

    private String getKey(int x,int y){
        return x+";"+y;
    }
}
