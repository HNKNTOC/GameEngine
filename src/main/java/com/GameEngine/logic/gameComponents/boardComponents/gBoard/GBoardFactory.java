package com.GameEngine.logic.gameComponents.boardComponents.gBoard;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Интерфейс фабрика для создания GBoard
 */
public interface GBoardFactory {
    /**
     * Создаёт GBoard.
     *
     * @return созданный GBoard.
     */
    GBoard createGBoard(int x, int y);

    /**
     * Создаёт GBoard.
     *
     * @return созданный GBoard.
     */
    GBoard createGBoard(ListGCell<GCell> listGCell);
}
