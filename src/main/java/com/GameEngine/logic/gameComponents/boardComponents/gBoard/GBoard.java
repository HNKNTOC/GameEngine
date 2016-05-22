package com.GameEngine.logic.gameComponents.boardComponents.gBoard;

import com.GameEngine.logic.gameComponents.GComponentAbstract;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Доска отображаюшая все GCellDefault которые содержатся в ListGCell
 */
public class GBoard extends GComponentAbstract<GPanel> {
    private static final Logger logger = LogManager.getLogger(GBoard.class);
    /**
     * Здесь содержатся GCellDefault которые должны отображятся на GBoard.
     */
    private ListGCell<GCell> listGCell;

    public GBoard(int x, int y) {
        this.listGCell = new HashMapPanelGCell(x, y);
        logger.info("Created " + toString());
    }

    public GBoard(ListGCell<GCell> listGCell) {
        this.listGCell = listGCell;
        logger.info("Created " + toString());
    }

    @Override
    public void setGPanel(GPanel gPanel) {
        super.setGPanel(gPanel);
        getGPanel().setLayout(new GridLayout(listGCell.getMaxX(), listGCell.getMaxY()));
    }

    public ListGCell<GCell> getListGCell() {
        return listGCell;
    }

    /**
     * Добовляет все GCellDefault находяшиеся в listGCell на свою панель.
     */
    public void updateGCell() {
        logger.info("updateGCell");
        JPanel panel = getGPanel();
        panel.removeAll();
        for (GCell gCell : listGCell) {
            panel.add(gCell.getGPanel());
        }
    }
}
