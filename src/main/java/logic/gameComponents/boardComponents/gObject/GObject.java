package logic.gameComponents.boardComponents.gObject;

import logic.gameComponents.GComponent;
import logic.gameComponents.gPanel.GPanel;
import logic.action.command.ReceiverAction;
import logic.resources.manager.ResManager;

import java.util.HashMap;


/**
 * Игровой обьект ноходящийся в клетку
 */
public class GObject extends GComponent {
    ReceiverAction receiverAction;

    private int x;
    private int y;

    public GObject() {
        GPanel panel = new GPanel();
        panel.setImageIcon(ResManager.getResManager().getImageIcon(2));
        setGPanel(panel);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public ReceiverAction getReceiverAction() {
        return receiverAction;
    }

    public void setReceiverAction(ReceiverAction receiverAction) {
        this.receiverAction = receiverAction;
    }

    @Override
    public String toString() {
        return "GObject{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
