package logic.gameComponents.boardComponents.gBoard;

import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListPanelGCell;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.gameComponents.boardComponents.gObject.list.ListGObject;

/**
 * Created by Nikita on 19.02.2016.
 */
public interface FactoryGBoard {
    GBoard createGBoard(int x,int y);
    GBoard createGBoard(ListGObject<GObject> listGObject, ListPanelGCell<GCell> listGCell);
}
