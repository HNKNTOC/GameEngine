package logic.gameComponents.boardComponents.gBoard;


import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;
import logic.gameComponents.gPanel.GPanel;

/**
 * Created by Nikita on 19.02.2016.
 */
public class GBoardFactoryDefault implements GBoardFactory {
    @Override
    public GBoard createGBoard(int x, int y) {
        GBoard gBoard = new GBoard(x, y);
        gBoard.setGPanel(new GPanel());
        return gBoard;
    }

    @Override
    public GBoard createGBoard(ListGCell<GCell> listGCell) {
        GBoard gBoard = new GBoard(listGCell);
        gBoard.setGPanel(new GPanel());
        return gBoard;
    }
}
