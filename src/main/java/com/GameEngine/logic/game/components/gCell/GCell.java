package com.GameEngine.logic.game.components.gCell;

import com.GameEngine.gui.gPanel.cell.GPanelCell;
import com.GameEngine.logic.game.components.GComponent;
import com.GameEngine.logic.game.components.gObject.GObject;

/**
 * Базовый интерфейс для всех клеток.
 */
public interface GCell extends GComponent<GPanelCell> {
    GObject getGObject();

    void setGObject(GObject gObject);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);


}
