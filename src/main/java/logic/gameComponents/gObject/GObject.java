package logic.gameComponents.gObject;

import logic.gameComponents.GameComponent;
import logic.gameComponents.gPanel.GPanel;
import logic.moveLogic.Move;
import logic.resources.loader.image.ImageLoader;


/**
 * Created by Nikita on 16.02.2016.
 */
public class GObject extends GameComponent {
    Move move;

    private int x;
    private int y;

    public GObject() {
        GPanel panel = new GPanel();
        panel.setIdImage(2);
        setGPanel(panel);

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

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }


}
