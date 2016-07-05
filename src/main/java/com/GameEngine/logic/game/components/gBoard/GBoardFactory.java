package com.GameEngine.logic.game.components.gBoard;

import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.list.ListGCell;

/**
 * Интерфейс фабрика для создания GBoard
 */
public interface GBoardFactory {
    /**
     * Создаёт GBoard.
     * @param x размер по x.
     * @param y размер по y.
     * @return созданный GBoard.
     */
    GBoard createGBoard(int x, int y);

    /**
     * Создаёт GBoard.
     * @param listGCell лист с GCell.
     * @return созданный GBoard.
     */
    GBoard createGBoard(ListGCell<GCell> listGCell);
}
