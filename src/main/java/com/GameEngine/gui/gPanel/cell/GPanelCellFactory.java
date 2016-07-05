package com.GameEngine.gui.gPanel.cell;


import com.GameEngine.gui.gPanel.GPanelFactory;

/**
 * Created by Nikita on 31.03.2016.
 */
public class GPanelCellFactory implements GPanelFactory<GPanelCell> {
    @Override
    public GPanelCell createGPanel(int id) {
        return new GPanelCell(id);
    }
}
