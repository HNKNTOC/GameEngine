package com.GameEngine.logic.action.command.gObject.command;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCellFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Тест для CommandMoveDefault
 */
public class CommandMoveDefaultTest {

    private static int maxY;
    private static int maxX;
    private static int randomX;
    private static int randomY;
    private static GBoard gBoard;
    private static GObject gObject;
    private static CommandMoveAbstract command;
    private static final Logger logger = LogManager.getLogger(CommandMoveDefaultTest.class);

    @BeforeClass
    public static void setUpClass() {
        maxY = getRandom(19) + 2;
        maxX = getRandom(19) + 2;
        logger.info("maxX=" + maxX + " maxY=" + maxY);
        GCellFactory GCellFactory = new GCellFactoryDefault(new GPanelCellFactory());
        ListGCell<GCell> listGCell = new HashMapPanelGCell(maxX, maxY);
        for (GCell gCell : GCellFactory.createGCell(maxX * maxY)) {
            listGCell.add(gCell);
        }
        gBoard = new GBoardFactoryDefault().createGBoard(listGCell);
        gObject = new GObject();
        command = new CommandMoveDefault(gObject, gBoard);
    }

    @Before
    public void setUp() {
        randomX = getRandom(maxX - 1);
        randomY = getRandom(maxY - 1);
        logger.info("randomX=" + randomX + " randomY=" + randomY);
    }

    @Test
    public void executeAndSetParameters() {
        int oldX = gObject.getX();
        int oldY = gObject.getY();
        command.setParameters(CommandMoveAbstract.NAME_PARAMETER_X, randomX + "");
        command.setParameters(CommandMoveAbstract.NAME_PARAMETER_Y, randomY + "");
        command.execute();

        assertTrue(checkMoving(randomX, randomY, oldX, oldY));
    }

    @Test
    public void move() {
        int oldX = gObject.getX();
        int oldY = gObject.getY();

        command.move(randomX, randomY, gObject.getX(), gObject.getY());
        assertTrue(checkMoving(randomX, randomY, oldX, oldY));
    }

    @Test
    public void checkMaxX() {
        assertTrue(command.checkMaxX(maxX - 1));
        assertTrue(!command.checkMaxX(maxX + 1));
        assertTrue(!command.checkMaxX(-1));
    }

    @Test
    public void checkMaxY() {
        assertTrue(command.checkMaxY(maxY - 1));
        assertTrue(!command.checkMaxY(maxY + 1));
        assertTrue(!command.checkMaxY(-1));
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

    private static int getRandom(int bound) {
        return new Random().nextInt(bound);
    }

}