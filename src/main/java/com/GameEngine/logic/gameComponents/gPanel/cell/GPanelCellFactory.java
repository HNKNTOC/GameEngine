package logic.gameComponents.gPanel.cell;


import logic.gameComponents.gPanel.GPanelFactory;

/**
 * Created by Nikita on 31.03.2016.
 */
public class GPanelCellFactory implements GPanelFactory<GPanelCell> {
    @Override
    public GPanelCell createGPanel() {
        return new GPanelCell();
    }
}
