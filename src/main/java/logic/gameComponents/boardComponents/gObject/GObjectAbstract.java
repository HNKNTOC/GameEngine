package logic.gameComponents.boardComponents.gObject;

import logic.action.command.ReceiverAction;
import logic.gameComponents.GComponentAbstract;
import logic.gameComponents.gPanel.GPanel;
import logic.resources.manager.ResManager;


/**
 * Игровой обьект ноходящийся в клетку
 */
public class GObjectAbstract extends GComponentAbstract<GPanel> {
    private ReceiverAction receiverAction;

    private int x;
    private int y;

    public GObjectAbstract() {
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
        return "GObjectAbstract{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
