package logic.gameComponents.gObject;

import java.util.ArrayList;

/**
 * Created by Nikita on 19.02.2016.
 */
public interface FactoryGObject {
    GObject createGObject();
    ArrayList<GObject> createGObject(int number);
}
