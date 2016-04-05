package logic.gameComponents.boardComponents.gBoard;

import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gCell.list.ListGCell;

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
