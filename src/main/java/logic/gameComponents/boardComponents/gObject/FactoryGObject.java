package logic.gameComponents.boardComponents.gObject;

import java.util.ArrayList;

/**
 * Фабрика для GObjectAbstract
 */
public interface FactoryGObject {
    GObjectAbstract createGObject();

    ArrayList<GObjectAbstract> createGObject(int number);
}
