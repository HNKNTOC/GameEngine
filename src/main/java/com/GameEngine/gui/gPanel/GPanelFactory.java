package com.GameEngine.gui.gPanel;

/**
 * Created by Nikita on 31.03.2016.
 */
public interface GPanelFactory<GPanel> {
    GPanel createGPanel(int id);
}
