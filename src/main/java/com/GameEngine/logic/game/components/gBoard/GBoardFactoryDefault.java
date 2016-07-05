package com.GameEngine.logic.game.components.gBoard;


import com.GameEngine.gui.gPanel.GPanel;
import com.GameEngine.gui.gPanel.GPanelDefaultFactory;
import com.GameEngine.gui.gPanel.GPanelFactory;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.list.ListGCell;

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
