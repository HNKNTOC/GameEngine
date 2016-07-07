package com.GameEngine.logic.game.components.gBoard;

import com.GameEngine.gui.gPanel.GPanel;
import com.GameEngine.gui.gPanel.GPanelDefaultFactory;
import com.GameEngine.gui.gPanel.cell.GPanelCell;
import com.GameEngine.logic.game.components.gCell.GCellDefault;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Тест функционала GBoard.
 */
public class GBoardTest {

    private static GBoard gBoard;
    private static final int x = (int) (Math.random() * 30);
    private static final int y = (int) (Math.random() * 30);

    @BeforeClass
    public static void set() {
        gBoard = new GBoardFactoryDefault(new GPanelDefaultFactory()).createGBoard(x, y);
    }

    /**
     * Проверка правильного создания ListGCell в GBoard
     */
    @Test
    public void getListGCell() {
        assertTrue(gBoard.getListGCell() != null);
    }

    @Test
    public void updateGCell() {
        GCellDefault gCell = new GCellDefault();
        gCell.setGPanel(new GPanelCell(gCell.getId()));
        gBoard.getListGCell().add(gCell);
        gBoard.updateGCell();
        assertTrue(gBoard.getGPanel().getComponent(0) == gCell.getGPanel());
    }

    /**
     * Проверяет совпадают ли id и hashCode
     */
    @Test
    public void getId() {
        assertTrue(gBoard.getId() == gBoard.hashCode());
    }

    @Test
    public void getGPanel() {
        assertNotNull(gBoard.getGPanel());
    }

    @Test
    public void setGPanel() {
        GPanel gPanel = new GPanel(1);
        gBoard.setGPanel(gPanel);
        assertTrue(gBoard.getGPanel() == gPanel);
    }

}