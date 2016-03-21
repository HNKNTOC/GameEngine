package logic.gameComponents.boardComponents.gObject.list;

import logic.gameComponents.boardComponents.gObject.GObject;

import java.util.*;


/**
 * Created by Nikita on 20.03.2016.
 */
public class ArrayListGObject extends ListGObject<GObject> {
    private ArrayList<GObject> listGObjects;

    public ArrayListGObject(ArrayList<GObject> listGObjects) {
        this.listGObjects = listGObjects;
    }

    public ArrayListGObject() {
        this.listGObjects = new ArrayList<>();
    }

    @Override
    public boolean add(GObject gObject) {
        notifyObservers();
        return listGObjects.add(gObject);
    }

    @Override
    public GObject get(int id) {
        return listGObjects.get(id);
    }

    @Override
    public int size() {
        return listGObjects.size();
    }

    @Override
    public Iterator<GObject> iterator() {
        return listGObjects.iterator();
    }
}
