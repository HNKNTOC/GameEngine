package logic.gameComponents.boardComponents.gBoard;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellDefault;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.gameComponents.gPanel.GPanelDefaultFactory;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Тест для GBoard.
 */
public class GBoardTest {

    private static GBoard gBoard;
    private static final int x = (int) (Math.random()*30);
    private static final int y = (int) (Math.random()*30);

    @BeforeClass
    public static void set() {
        gBoard = new GBoardFactoryDefault(new GPanelDefaultFactory()).createGBoard(x, y);
    }

    /**
     * Проверка правильного создания ListGCell в GBoard
     */
    @Test
    public void getListGCell(){
        assertTrue(gBoard.getListGCell()!= null);
    }

    @Test
    public void updateGCell(){
        GCellDefault gCell = new GCellDefault();
        gCell.setGPanel(new GPanelCell());
        gBoard.getListGCell().add(gCell);
        gBoard.updateGCell();
        assertTrue(gBoard.getGPanel().getComponent(0) == gCell.getGPanel());
    }

    /**
     * Проверяет совпадают ли id и hashCode
     */
    @Test
    public void getId() {
        assertTrue(gBoard.getId()==gBoard.hashCode());
    }

    @Test
    public void getGPanel() {
        assertNotNull(gBoard.getGPanel());
    }

    @Test
    public void setGPanel() {
        GPanel gPanel = new GPanel();
        gBoard.setGPanel(gPanel);
        assertTrue(gBoard.getGPanel() == gPanel);
    }
}