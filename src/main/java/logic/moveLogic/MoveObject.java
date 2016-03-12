package logic.moveLogic;

import logic.gameComponents.boardComponents.list.ListGCell;
import logic.gameComponents.gCell.GCell;
import logic.gameComponents.gObject.GObject;

/**
 * Created by Nikita on 16.02.2016.
 */
public class MoveObject implements Move {

    private GObject gObject;
    private ListGCell listGCell;

    public MoveObject(GObject gObject, ListGCell listGCell) {
        this.listGCell = listGCell;
        this.gObject = gObject;
    }

    @Override
    public void move(int x, int y) {
        if (check(x,y)) {
            changePosition(x,y);
        }
    }

    @Override
    public int getX() {
        return gObject.getX();
    }

    @Override
    public int getY() {
        return gObject.getY();
    }

    /**
     * Перемешение gObject.
     */
    void changePosition(int x,int y) {
        GCell newGCell = listGCell.get(x,y);
        GCell oldGCell = listGCell.get(gObject.getX(),gObject.getY());



        //Убераем обьект
        oldGCell.setGObject(null);
        oldGCell.getGPanel().removeAll();

        //Устанавливаем объект на новое место
        newGCell.setGObject(gObject);

        System.out.println("Repaint: "+newGCell.getX()+","+newGCell.getY()+"\n" +
                "Object="+newGCell.getGObject());
        System.out.println("Repaint: "+oldGCell.getX()+","+oldGCell.getY()+"\n" +
                "Object="+oldGCell.getGObject());

    }

    /**
     * Проверяет превышает ли sizeColumn и sizeRows максимум и уходят ли они в минус.
     *
     * @return false если sizeColumn или sizeRows превышают максимум или уходят в минус.
     */
    private boolean check(int x,int y) {
        return (x < listGCell.getMaxX() & y < listGCell.getMaxY() & x >= 0 & y >= 0);
    }
}
