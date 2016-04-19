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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 18.04.2016.
 */
public class CommandMoveAbstractTest {

    private static int maxY;
    private static int maxX;
    private static int randomX;
    private static int randomY;
    private static GBoard gBoard;
    private static GObject gObject;
    private static CommandMoveAbstract command;
    private static final Logger logger = LogManager.getLogger(CommandMoveAbstractTest.class);

    @BeforeClass
    public static void setUpClass() {
        maxY = getRandom(19) + 1;
        maxX = getRandom(19) + 1;
        logger.info("maxX=" + maxX + " maxY=" + maxY);
        GCellFactory GCellFactory = new GCellFactoryDefault(new GPanelCellFactory());
        ListGCell<GCell> listGCell = new HashMapPanelGCell(maxX, maxY);
        for (GCell gCell : GCellFactory.createGCell(maxX * maxY)) {
            listGCell.add(gCell);
        }
        gBoard = new GBoardFactoryDefault().createGBoard(listGCell);
        gObject = new GObject();
        gObject.setX(randomX);
        gObject.setY(randomY);
        command = new CommandMoveDefault(gObject, gBoard);
    }

    @Before
    public void setUp() {
        randomX = getRandom(maxX);
        randomY = getRandom(maxY);
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
        assertTrue(command.checkMaxX(maxX));
        assertTrue(!command.checkMaxX(maxX + 1));
        assertTrue(!command.checkMaxX(-1));
    }

    @Test
    public void checkMaxY() {
        assertTrue(command.checkMaxY(maxY));
        assertTrue(!command.checkMaxY(maxY + 1));
        assertTrue(!command.checkMaxY(-1));
    }


    private boolean checkMoving(int randomX, int randomY, int oldX, int oldY) {
        ListGCell<GCell> listGCell = gBoard.getListGCell();
        return listGCell.get(oldX, oldY).getGObject() == null &
                listGCell.get(randomX, randomY).getGObject() == gObject;
    }

    private static int getRandom(int bound) {
        return new Random().nextInt(bound);
    }

}