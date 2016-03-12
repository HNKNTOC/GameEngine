package logic.gameComponents.boardComponents;

import logic.gameComponents.GameComponent;
import logic.gameComponents.boardComponents.list.HashMapGCell;
import logic.gameComponents.boardComponents.list.ListGCell;
import logic.gameComponents.gCell.GCell;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by Nikita on 16.02.2016.
 */
public class GBoard extends GameComponent {

    private ListGCell listGCell;

    public GBoard(int x, int y) {
        listGCell = new HashMapGCell(x,y,this);
        getGPanel().setLayout(new GridLayout(x,y));
    }

    public ListGCell getListGCell() {
        return listGCell;
    }

    public void setListGCell(ListGCell listGCell) {
        this.listGCell = listGCell;
    }

    public void update(){
        Iterator<GCell> iterator = listGCell.getIterator();
        JPanel panel = getGPanel();
        panel.removeAll();
        while (iterator.hasNext()){
            panel.add(iterator.next().getGPanel());
        }
    }

}
