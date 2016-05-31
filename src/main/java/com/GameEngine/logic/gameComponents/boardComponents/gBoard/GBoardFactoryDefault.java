package com.GameEngine.logic.gameComponents.boardComponents.gBoard;


import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.gameComponents.gPanel.GPanelDefaultFactory;
import com.GameEngine.logic.gameComponents.gPanel.GPanelFactory;

/**
 * Фабрика для создания GBoard.
 */
public class GBoardFactoryDefault implements GBoardFactory {
    private GPanelFactory<GPanel> factory;

    public GBoardFactoryDefault() {
        factory = new GPanelDefaultFactory();
    }

    public GBoardFactoryDefault(GPanelFactory<GPanel> factory) {
        this.factory = factory;
    }

    @Override
    public GBoard createGBoard(int x, int y) {
        GBoard gBoard = new GBoard(x, y);
        gBoard.setGPanel(factory.createGPanel(gBoard.getId()));
        return gBoard;
    }

    @Override
    public GBoard createGBoard(ListGCell<GCell> listGCell) {
        GBoard gBoard = new GBoard(listGCell);
        gBoard.setGPanel(factory.createGPanel(gBoard.getId()));
        return gBoard;
    }
}
