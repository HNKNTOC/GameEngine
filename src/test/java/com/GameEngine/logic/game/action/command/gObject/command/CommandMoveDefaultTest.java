package com.GameEngine.logic.game.action.command.gObject.command;

import com.GameEngine.gui.gPanel.cell.GPanelCellFactory;
import com.GameEngine.logic.game.components.gBoard.GBoard;
import com.GameEngine.logic.game.components.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.GCellFactory;
import com.GameEngine.logic.game.components.gCell.GCellFactoryDefault;
import com.GameEngine.logic.game.components.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.game.components.gCell.list.ListGCell;
import com.GameEngine.logic.game.components.gObject.GObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тест для CommandMoveDefault
 */
public class CommandMoveDefaultTest {

    private static final int MAX_Y = 20;
    private static final int MAX_X = 25;
    private static final int X = 15;
    private static final int Y = 17;
    private static GBoard gBoard;
    private static GObject gObject;
    private static CommandMoveGObject command;
    private static final Logger logger = LogManager.getLogger(CommandMoveDefaultTest.class);

    @BeforeClass
    public static void setUpClass() {
        logger.info("maxX=" + MAX_X + " maxY=" + MAX_Y);
        GCellFactory GCellFactory = new GCellFactoryDefault(new GPanelCellFactory());
        ListGCell<GCell> listGCell = new HashMapPanelGCell(MAX_X, MAX_Y);
        for (GCell gCell : GCellFactory.createGCell(MAX_X * MAX_Y)) {
            listGCell.add(gCell);
        }
        gBoard = new GBoardFactoryDefault().createGBoard(listGCell);
        gObject = new GObject();
        command = new CommandMoveDefault(gObject, gBoard);
    }

    @Before
    public void setUp() {
        logger.info("X=" + X + " Y=" + Y);
    }

    @Test
    public void executeAndSetParameters() {
        int oldX = gObject.getX();
        int oldY = gObject.getY();
        command.getDynamicValues().putParameterInt(CommandMoveGObject.NAME_PARAMETER_X, X);
        command.getDynamicValues().putParameterInt(CommandMoveGObject.NAME_PARAMETER_Y, Y);
        command.execute();

        assertTrue(checkMoving(X, Y, oldX, oldY));
    }


    @Test
    public void move() {
        int oldX = gObject.getX();
        int oldY = gObject.getY();

        command.move(X, Y, gObject.getX(), gObject.getY());
        assertTrue(checkMoving(X, Y, oldX, oldY));
    }

    @Test
    public void checkMaxX() {
        assertTrue(command.checkMaxX(MAX_X - 1));
        assertFalse(command.checkMaxX(MAX_X + 1));
        assertFalse(command.checkMaxX(-1));
    }

    @Test
    public void checkMaxY() {
        assertTrue(command.checkMaxY(MAX_Y - 1));
        assertFalse(command.checkMaxY(MAX_Y + 1));
        assertFalse(command.checkMaxY(-1));
    }


    private boolean checkMoving(int randomX, int randomY, int oldX, int oldY) {
        ListGCell<GCell> listGCell = gBoard.getListGCell();

        if (randomX == oldX & randomY == oldY) {
            logger.info("randomX==oldX & randomY==oldY)");
            return true;
        }

        if (!(listGCell.get(oldX, oldY).getGObject() == null)) {
            logger.info("old x=" + oldX + " y=" + oldY + " not == null");
            return false;
        }
        if (!(listGCell.get(randomX, randomY).getGObject() == gObject)) {
            logger.info("new x =" + randomX + " y =" + randomY + " not == gObject");
            return false;
        }
        return true;
    }
}