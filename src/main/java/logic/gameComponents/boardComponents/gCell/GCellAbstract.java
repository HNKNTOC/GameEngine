package logic.gameComponents.boardComponents.gCell;

import logic.gameComponents.GComponentAbstract;
import logic.gameComponents.boardComponents.gObject.GObjectAbstract;
import logic.gameComponents.gPanel.cell.GPanelCell;

/**
 * Базовый класс для всех клеток.
 */
public abstract class GCellAbstract extends GComponentAbstract<GPanelCell> implements GCell {
    private GObjectAbstract gObject;
    private int x;
    private int y;


    @Override
    public GObjectAbstract getGObject() {
        return gObject;
    }

    @Override
    public void setGObject(GObjectAbstract gObject) {
        this.gObject
                = gObject;
        updateGPanel();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Оповешает GPanel об изменениях в GCellDefault.
     */
    abstract protected void updateGPanel();
}
