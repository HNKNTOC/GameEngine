package logic.gameComponents.boardComponents.gObject;

import java.util.ArrayList;

/**
 * Фабрика для GObject
 */
public interface FactoryGObject {
    GObject createGObject();
    ArrayList<GObject> createGObject(int number);
}
