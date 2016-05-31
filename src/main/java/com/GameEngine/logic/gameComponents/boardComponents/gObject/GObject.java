package com.GameEngine.logic.gameComponents.boardComponents.gObject;

import com.GameEngine.logic.action.command.ReceiverAction;
import com.GameEngine.logic.action.command.ReceiverHashMap;
import com.GameEngine.logic.gameComponents.GComponentAbstract;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;


/**
 * Игровой обьект ноходящийся в клетке
 */
public class GObject extends GComponentAbstract<GPanel> {
    private ReceiverAction receiverAction;

    /**
     * Кордината по оси X на которой находится GObject.
     */
    private int x;
    /**
     * Кордината по оси Y на которой находится GObject.
     */
    private int y;

    public GObject() {
        this(0, 0);
    }

    public GObject(int x, int y) {
        this(x, y, new ReceiverHashMap());
    }

    public GObject(int x, int y, ReceiverAction receiverAction) {
        this.receiverAction = receiverAction;
        this.x = x;
        this.y = y;
        GPanel panel = new GPanel(getId());
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
