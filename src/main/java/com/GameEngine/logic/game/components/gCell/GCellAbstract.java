package com.GameEngine.logic.game.components.gCell;

import com.GameEngine.gui.gPanel.cell.GPanelCell;
import com.GameEngine.logic.game.components.GComponentAbstract;
import com.GameEngine.logic.game.components.gObject.GObject;

/**
 * Базовый класс для всех клеток.
 */
public abstract class GCellAbstract extends GComponentAbstract<GPanelCell> implements GCell {
    private GObject gObject;
    private int x;
    private int y;


    @Override
    public GObject getGObject() {
        return gObject;
    }

    @Override
    public void setGObject(GObject gObject) {
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
        updateGPanel();
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
        updateGPanel();
    }

    /**
     * Оповешает GPanel об изменениях в GCellDefault.
     */
    abstract protected void updateGPanel();
}
