package logic.gameComponents.gCell;


import logic.gameComponents.gPanel.cell.GCellPanel;
import logic.gameComponents.gPanel.cell.GCellPanelInf;

import java.util.ArrayList;

/**
 * Created by Nikita on 19.02.2016.
 */
public class FactoryGCellDefault implements FactoryGCell {
    @Override
    public GCell createGCell() {
        GCell gCell = new GCell();
        GCellPanel panel = new GCellPanelInf(gCell);
        panel.setIdImage(1);
        gCell.setGPanel(panel);
        return gCell;
    }

    @Override
    public ArrayList<GCell> createGCell(int number) {
        ArrayList<GCell> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(createGCell());
        }
        return list;
    }
}
