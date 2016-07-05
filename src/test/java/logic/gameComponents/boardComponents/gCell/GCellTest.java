package logic.gameComponents.boardComponents.gCell;

import com.GameEngine.gui.gPanel.cell.GPanelCellFactory;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.GCellFactoryDefault;
import com.GameEngine.logic.game.components.gObject.GObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
/**
 * Тест для GCell.
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