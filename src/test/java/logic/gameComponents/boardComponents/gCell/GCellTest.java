package logic.gameComponents.boardComponents.gCell;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCellFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
/**
 * Created by Nikita on 05.04.2016.
 */
public class GCellTest {

    private GCell cell = new GCellFactoryDefault(new GPanelCellFactory()).createGCell();
    private int x = new Random().nextInt(500);
    private int y = new Random().nextInt(500);

    @Before
    public void setUp() throws Exception {
        cell.setGObject(null);
    }

    @Test
    public void setAndGetGObject() throws Exception {
        GObject object = new GObject();
        cell.setGObject(object);
        assertTrue(cell.getGObject() == object);
    }

    @Test
    public void checkCoordinateX() throws Exception {
        cell.setX(x);
        assertTrue(cell.getX() == x);
    }

    @Test
    public void checkCoordinateY() throws Exception {
        cell.setY(y);
        assertTrue(cell.getY() == y);
    }
}