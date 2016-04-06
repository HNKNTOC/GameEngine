package com.GameEngine.logic.gameComponents.gPanel.cell;

import com.GameEngine.logic.dynamicValues.Dynamic;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;

import java.awt.*;

/**
 * Панель для GCellDefault отображает объект находящийся в GCellDefault.
 */
public class GPanelCell extends GPanel implements Dynamic {

    private GPanel gPanelObject;
    /**
     * Хранит в себе динамические параметры и может добавлять новые.
     */
    private DynamicParameterMap mapParameter;

    public GPanelCell() {
        this.mapParameter = new DynamicParameterMap();
    }

    public GPanel getGPanelObject() {
        return gPanelObject;
    }

    public void setGPanelObject(GPanel gPanelObject) {
        this.gPanelObject = gPanelObject;
    }

    @Override
    public DynamicParameter<String, String> getDynamicValues() {
        return mapParameter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        if (gPanelObject != null) {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5, 5, 5, 5);
            c.weightx = 1;
            c.weighty = 1;
            c.fill = GridBagConstraints.BOTH;
            add(gPanelObject, c);
        }
    }
}
