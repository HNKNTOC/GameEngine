package logic.gameComponents.boardComponents.gBoard;

import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;
import logic.gameComponents.gPanel.GPanel;
import logic.gameComponents.gPanel.cell.GPanelCell;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nikita on 31.03.2016.
 */
public class GBoardTest {

    private static GBoard gBoard;
    private static final int x = (int) (Math.random()*30);
    private static final int y = (int) (Math.random()*30);

    @BeforeClass
    public static void set() {
        gBoard = new GBoard(x,y);
    }

    /**
     * Проверка правельного создания ListGCell в GBoard
     */
    @Test
    public void getListGCell(){
        assertTrue(gBoard.getListGCell()!= null);
    }

    @Test
    public void updateGCell(){
        GCell gCell = new GCell();
        gBoard.getListGCell().add(gCell);
        gBoard.updateGCell();
        assertTrue(gBoard.getGPanel().getComponent(0) == gCell.getGPanel());
    }

    /**
     * Проверяет совподают ли id и hashCode
     * @throws Exception
     */
    @Test
    public void getId() throws Exception {
        assertTrue(gBoard.getId()==gBoard.hashCode());
    }

    @Test
    public void getGPanel() throws Exception {
        assertTrue(gBoard.getGPanel()!=null);
    }

    @Test
    public void setGPanel() throws Exception {
        GPanel gPanel = new GPanel();
        gBoard.setGPanel(gPanel);
        assertTrue(gBoard.getGPanel() == gPanel);
    }
}