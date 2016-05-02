package com.GameEngine.logic.gameComponents.gPanel.cell;

import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 01.05.2016.
 */
public class GPanelCellTest {

    private GPanelCell panel;

    @Before
    public void setUp() throws Exception {
        panel = new GPanelCell();
    }

    @Test
    public void getAndSetGPanelObject() throws Exception {
        GPanel gPanelObject = new GPanel();
        panel.setGPanelObject(gPanelObject);
        assertTrue(panel.getGPanelObject() == gPanelObject);
    }

}