package logic.gameComponents.boardComponents.gCell;

import java.util.ArrayList;

/**
 * Created by Nikita on 19.02.2016.
 */
public interface GCellFactory {
    /**
     * Создаёт GCell и возврашает её.
     *
     * @return GCell.
     */
    GCell createGCell();

    /**
     * Создаёт указенное количество GCell и возврашает их в ArrayList.
     *
     * @param number количество GCell которое нужно создать.
     * @return ArrayList с созданными GCell.
     */
    ArrayList<GCell> createGCell(int number);
}
