package logic.gameComponents.gCell;

import logic.gameComponents.GameComponent;
import logic.gameComponents.gObject.GObject;

/**
 * Created by Nikita on 16.02.2016.
 */
public class GCell extends GameComponent {

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
        if (gObject!=null) {
            gObject.setX(x);
            gObject.setY(y);
        }
    }
}
