package logic.gameComponents.boardComponents.gBoard;


import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 19.02.2016.
 */
public class FactoryGBoardDefault implements FactoryGBoard {
    @Override
    public GBoard createGBoard(int x, int y) {
        return new GBoard(x,y);
    }

    @Override
    public GBoard createGBoard(ListGCell<GCell> listGCell) {
        return new GBoard(listGCell);
    }
}
