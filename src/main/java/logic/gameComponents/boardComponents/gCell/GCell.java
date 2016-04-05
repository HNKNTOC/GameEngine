package logic.gameComponents.boardComponents.gCell;

import logic.gameComponents.GComponent;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.gameComponents.gPanel.cell.GPanelCell;

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
