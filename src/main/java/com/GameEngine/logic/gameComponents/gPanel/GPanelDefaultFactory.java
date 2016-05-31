package com.GameEngine.logic.gameComponents.gPanel;

/**
 * Created by Nikita on 31.03.2016.
 */
public class GPanelDefaultFactory implements GPanelFactory<GPanel> {
    @Override
    public GPanel createGPanel(int id) {
        return new GPanel(id);
    }
}
