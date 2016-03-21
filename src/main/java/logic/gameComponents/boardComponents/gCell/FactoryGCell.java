package logic.gameComponents.boardComponents.gCell;

import java.util.ArrayList;

/**
 * Created by Nikita on 19.02.2016.
 */
public interface FactoryGCell {
    GCell createGCell();
    ArrayList<GCell> createGCell(int number);
}
