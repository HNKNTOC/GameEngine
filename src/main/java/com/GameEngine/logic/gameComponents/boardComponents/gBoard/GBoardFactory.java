package com.GameEngine.logic.gameComponents.boardComponents.gBoard;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

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
