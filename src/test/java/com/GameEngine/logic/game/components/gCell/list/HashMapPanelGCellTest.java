package com.GameEngine.logic.game.components.gCell.list;

import com.GameEngine.gui.gPanel.cell.GPanelCellFactory;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.GCellDefault;
import com.GameEngine.logic.game.components.gCell.GCellFactory;
import com.GameEngine.logic.game.components.gCell.GCellFactoryDefault;
import com.GameEngine.logic.game.components.gObject.GObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;

/**
 * Тест для HashMapPanelGCell
 */
public class HashMapPanelGCellTest {
    private static final int MAX_X = 20;
    private static final int MAX_Y = 25;
    private static final int X = 15;
    private static final int Y = 17;
    private static final int LIST_SIZE = MAX_X * MAX_Y;

    /**
     * Фабрика создающая
     */
    private final GCellFactory factory = new GCellFactoryDefault(new GPanelCellFactory());
    /**
     * Тестируемый класс.
     */
    private ListGCell<GCell> listGCell;


    @Before
    public void setUp() throws Exception {
        //Создание gCells и наполнение его GCell
        int x = 0, y = 0;
        GCell[][] gCells = new GCellDefault[MAX_X][MAX_Y];
        for (int i = gCells.length; i > 0; i--) {
            for (int i1 = gCells[0].length; i1 > 0; i1--) {
                GCell gCell = factory.createGCell();
                gCell.setX(x);
                gCell.setY(y);
                gCells[x][y] = gCell;
                y++;
            }
            y = 0;
            x++;
        }
        //Создание ListGCell и наполнение его GCell из gCells
        listGCell = new HashMapPanelGCell(MAX_X, MAX_Y);

        for (GCell[] list : gCells) {
            for (GCell cell : list) {
                listGCell.add(cell);
            }
        }
    }

    @Test
    public void testGet() throws Exception {

        for (int i = 0; i < 10; i++) {
            GCell gCell = listGCell.get(X, Y);
            assertTrue(gCell.getX() == X & gCell.getY() == Y);
        }
    }


    @Test
    public void testSet() throws Exception {
        GCell gCell = factory.createGCell();
        GObject gObject = new GObject();
        gCell.setGObject(gObject);

        for (int i = 0; i < 10; i++) {
            listGCell.set(gCell, X, Y);
            GCell gCellTest = listGCell.get(X, Y);
            assertTrue(gCellTest == gCell);
            assertTrue(gCellTest.getGObject() == gObject);
        }
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(listGCell.size() == LIST_SIZE);
    }

    @Test
    public void testGetMaxX() throws Exception {
        assertTrue(listGCell.getMaxX() == MAX_X);
    }

    @Test
    public void testGetMaxY() throws Exception {
        assertTrue(listGCell.getMaxY() == MAX_Y);
    }

    @Test
    public void testGetIterator() throws Exception {
        Iterator<GCell> iterator = listGCell.iterator();

        int x = 0, y = 0;
        while (iterator.hasNext()) {

            GCell gCell = iterator.next();

            assertTrue(gCell.getX() == x & gCell.getY() == y);

            x++;
            if (x >= MAX_X) {
                x = 0;
                y++;
            }
        }
    }
}