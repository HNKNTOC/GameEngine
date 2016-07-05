package com.GameEngine.gui.gPanel.cell;

import com.GameEngine.gui.gPanel.GPanel;
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
        panel = new GPanelCell(1);
    }

    @Test
    public void getAndSetGPanelObject() throws Exception {
        GPanel gPanelObject = new GPanel(1);
        panel.setGPanelObject(gPanelObject);
        assertTrue(panel.getGPanelObject() == gPanelObject);
    }

}