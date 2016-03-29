package logic.gameComponents.boardComponents.gCell;


import logic.gameComponents.gPanel.cell.GPanelCell;
import logic.gameComponents.gPanel.cell.GPanelCellInf;
import logic.resources.manager.ResManager;

import java.util.ArrayList;

/**
 * Created by Nikita on 19.02.2016.
 */
public class FactoryGCellDefault implements FactoryGCell {
    @Override
    public GCell createGCell() {
        GCell gCell = new GCell();
        GPanelCell panel = new GPanelCellInf(gCell);
        panel.setImageIcon(ResManager.getResManager().getImageIcon(1));
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
