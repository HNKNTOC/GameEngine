package com.GameEngine.logic.gameComponents.boardComponents.gCell;

import com.GameEngine.logic.gameComponents.GComponent;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;

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
