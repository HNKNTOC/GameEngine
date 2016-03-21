package logic.gameComponents.boardComponents.gBoard;

import logic.gameComponents.GComponent;
import logic.gameComponents.boardComponents.gCell.list.HashMapPanelGCell;
import logic.gameComponents.boardComponents.gCell.list.ListPanelGCell;
import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.gameComponents.boardComponents.gObject.list.ArrayListGObject;
import logic.gameComponents.boardComponents.gObject.list.ListGObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nikita on 16.02.2016.
 */
public class GBoard extends GComponent {
    private static final Logger logger = LogManager.getLogger(GBoard.class);
    /**
     * Здесь содержатся GCell которые должны отображятся на GBoard.
     */
    private ListPanelGCell<GCell> listGCell;
    /**
     * Здесь содержатся GObject которые должны отображятся на GBoard.
     */
    private ListGObject<GObject> listGObject;

    public GBoard(int x, int y) {
        this.listGCell = new HashMapPanelGCell(x, y);
        this.listGObject = new ArrayListGObject();
        getGPanel().setLayout(new GridLayout(x, y));
        logger.info("Created " + toString());
        update();
    }

    public GBoard(ListGObject<GObject> listGObject, ListPanelGCell<GCell> listGCell) {
        this.listGCell = listGCell;
        this.listGObject = listGObject;
        int x = listGCell.getMaxX();
        int y = listGCell.getMaxY();
        getGPanel().setLayout(new GridLayout(x, y));
        logger.info("Created " + toString());
        update();
    }

    public ListPanelGCell<GCell> getListGCell() {
        return listGCell;
    }

    public void setListGCell(ListPanelGCell<GCell> listGCell) {
        this.listGCell = listGCell;
    }

    /**
     * Отображает все элементы находяшиийся в listGCell и listGObject.
     */
    public void update() {
        logger.info("update");
        updateGCell();
    }

    /**
     * Отображает все элементы из listGCell.
     */
    public void updateGCell() {
        logger.info("updateGCell");
        JPanel panel = getGPanel();
        panel.removeAll();
        for (GCell gCell : listGCell) {
            panel.add(gCell.getGPanel());
        }
    }

    /**
     * Отображает все элементы из listGObject.
     */
    public void updateGObject() {
        logger.info("updateGObject");
        for (GObject gObject : listGObject) {
            logger.info("" + gObject.toString());
            logger.info("set x=" + gObject.getX() + " ;y=" + gObject.getY());
            listGCell.get(gObject.getX(), gObject.getY()).setGObject(gObject);
        }
    }
}
