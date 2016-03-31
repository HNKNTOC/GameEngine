package logic.gameComponents.boardComponents.gBoard;

import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 19.02.2016.
 */
public interface GBoardFactory {
    GBoard createGBoard(int x,int y);
    GBoard createGBoard(ListGCell<GCell> listGCell);
}
