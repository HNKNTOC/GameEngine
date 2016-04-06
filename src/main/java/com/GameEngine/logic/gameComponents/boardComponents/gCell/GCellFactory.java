package logic.gameComponents.boardComponents.gCell;

import java.util.ArrayList;

/**
 * Интерфейс фабрика для создания GCell и ArrayList<GCell>
 */
public interface GCellFactory {
    /**
     * Создаёт GCell.
     * @return созданный GCell.
     */
    GCell createGCell();

    /**
     * Создаёт указенное количество GCell и возврашает их в ArrayList.
     * @param number количество GCell которое нужно создать.
     * @return ArrayList с созданными GCell.
     */
    ArrayList<GCell> createGCell(int number);
}
