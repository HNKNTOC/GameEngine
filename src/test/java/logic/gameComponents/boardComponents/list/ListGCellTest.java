package logic.gameComponents.boardComponents.list;

import logic.gameComponents.boardComponents.GBoard;
import logic.gameComponents.gCell.GCell;
import logic.gameComponents.gObject.GObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;


import static org.junit.Assert.*;

/**
 * Created by Nikita on 16.02.2016.
 */
public class ListGCellTest {
    int maxX = 10;
    int maxY = 5;
    int size = maxX*maxY;

    ListGCell managerGCell;
    GCell[][] gCells = new GCell[maxX][maxY];

    @BeforeClass
    public static void start(){
    }

    @Before
    public void setUp() throws Exception {
        //Создание gCells и наполнение его GCell
        int x=0,y=0;

        for(int i=gCells.length;i>0;i--){
            for(int i1=gCells[0].length;i1>0;i1--){
                GCell gCell = new GCell();
                gCell.setX(x);
                gCell.setY(y);
                gCells[x][y]=gCell;
                y++;
            }
            y=0;
            x++;
        }
        //Создание ListGCell и наполнение его GCell из gCells
        managerGCell = new HashMapGCell(maxX,maxY,new GBoard(maxX,maxY));

        for(GCell[] list:gCells){
            for(GCell cell:list){
                managerGCell.add(cell);
            }
        }
    }

    @Test
    public void testGet() throws Exception {

        for(int i=0;i<10;i++){
            int x = getRandomX(),y=getRandomY();
            GCell gCell = managerGCell.get(x,y);
            assertTrue(gCell.getX()==x & gCell.getY()==y);
        }
    }


    @Test
    public void testSet() throws Exception {
        GCell gCell = new GCell();
        GObject gObject = new GObject();
        gCell.setGObject(gObject);

        for(int i=0;i<10;i++){
            int x = getRandomX(),y=getRandomY();
            managerGCell.set(gCell, x, y);
            GCell gCellTest = managerGCell.get(x, y);
            assertTrue(gCellTest == gCell);
            assertTrue(gCellTest.getGObject()==gObject);
        }
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(managerGCell.size() == size);
    }

    @Test
    public void testGetMaxX() throws Exception {
        assertTrue(managerGCell.getMaxX()==maxX);
    }

    @Test
    public void testGetMaxY() throws Exception {
        assertTrue(managerGCell.getMaxY() == maxY);
    }

    @Test
    public void testGetIterator() throws Exception {
        Iterator<GCell> iterator = managerGCell.getIterator();

        int x=0,y=0;
        while (iterator.hasNext()){

            GCell gCell = iterator.next();

            assertTrue(gCell.getX()==x & gCell.getY()==y);

            x++;
            if (x >= maxX) {
                x = 0;
                y++;
            }
        }
    }

    private int getRandomX(){
        Random random = new Random();
        return random.nextInt(maxX);
    }

    private int getRandomY(){
        Random random = new Random();
        return random.nextInt(maxY);
    }
}