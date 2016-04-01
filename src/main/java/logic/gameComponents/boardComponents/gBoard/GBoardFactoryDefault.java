package logic.gameComponents.boardComponents.gBoard;


import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;
import logic.gameComponents.gPanel.GPanel;
import logic.gameComponents.gPanel.GPanelFactory;

/**
 * Created by Nikita on 19.02.2016.
 */
public class GBoardFactoryDefault implements GBoardFactory {
    private GPanelFactory<GPanel> factory;

    public GBoardFactoryDefault(GPanelFactory<GPanel> factory) {
        this.factory = factory;
    }

    @Override
    public GBoard createGBoard(int x, int y) {
        GBoard gBoard = new GBoard(x, y);
        gBoard.setGPanel(factory.createGPanel());
        return gBoard;
    }

    @Override
    public GBoard createGBoard(ListGCell<GCell> listGCell) {
        GBoard gBoard = new GBoard(listGCell);
        gBoard.setGPanel(factory.createGPanel());
        return gBoard;
    }
}