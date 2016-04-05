package logic.gameComponents.boardComponents.gCell;

import logic.gameComponents.boardComponents.gObject.GObject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nikita on 05.04.2016.
 */
public class GCellTest {

    private GCell cell = new GCellDefault();

    @Before
    public void setUp() throws Exception {
        cell.setGObject(null);
    }

    @Test
    public void setGObject() throws Exception {
        cell.setGObject(new GObject());
    }

    @Test
    public void getGObject() throws Exception {

    }

    @Test
    public void getX() throws Exception {

    }

    @Test
    public void setX() throws Exception {

    }

    @Test
    public void getY() throws Exception {

    }

    @Test
    public void setY() throws Exception {

    }

}