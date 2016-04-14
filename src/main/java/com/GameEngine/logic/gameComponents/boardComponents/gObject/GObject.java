package com.GameEngine.logic.gameComponents.boardComponents.gObject;

import com.GameEngine.logic.action.command.ReceiverAction;
import com.GameEngine.logic.gameComponents.GComponentAbstract;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.manager.ResManager;


/**
 * Игровой обьект ноходящийся в клетку
 */
public class GObject extends GComponentAbstract<GPanel> {
    private ReceiverAction receiverAction;

    private int x;
    private int y;

    public GObject() {
        GPanel panel = new GPanel();
        panel.setImageIcon(ResManager.getResManager().getImageIcon(ImageName.OBJECT));
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
