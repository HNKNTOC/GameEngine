package logic.gameComponents.boardComponents.gCell;

import logic.gameComponents.gPanel.cell.GPanelCell;
import logic.gameComponents.gPanel.cell.GPanelCellFactory;
import logic.gameComponents.gPanel.cell.GPanelCellInf;
import logic.resources.manager.ResManager;

import java.util.ArrayList;

/**
 * Стандартная реализация для GCellFactory.
 */
public class GCellFactoryDefault implements GCellFactory {
    private GPanelCellFactory factory;

    public GCellFactoryDefault(GPanelCellFactory factory) {
        this.factory = factory;
    }

    @Override
    public GCell createGCell() {
        GCell gCell = new GCellDefault();
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
