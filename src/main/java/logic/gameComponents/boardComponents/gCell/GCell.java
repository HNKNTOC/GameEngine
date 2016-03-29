package logic.gameComponents.boardComponents.gCell;


import logic.gameComponents.GComponent;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.gameComponents.gPanel.cell.GPanelCell;


/**
 *  Базовый класс для всех клеток.
 */
public class GCell extends GComponent<GPanelCell> {

    private GObject gObject;

    private int x;
    private int y;

    public GCell() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GObject getGObject() {
        return gObject;
    }

    public void setGObject(GObject gObject) {
        this.gObject = gObject;
        updateGPanel();
    }

    /**
     * Обновляет image в GPanel.
     */
     private void updateGPanel(){
        if (gObject == null) {
            getGPanel().setGPanelObject(null);
        }else {
            getGPanel().setGPanelObject(gObject.getGPanel());
        }
    }




}
