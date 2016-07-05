package com.GameEngine.logic.game.components.gCell;


/**
 * Базовый класс для всех клеток.
 */
public class GCellDefault extends GCellAbstract {
    @Override
    protected void updateGPanel() {
        if (getGObject() == null) {
            getGPanel().setGPanelObject(null);
        } else {
            getGPanel().setGPanelObject(getGObject().getGPanel());
        }
        getGPanel().getDynamicValues().putParameterInt("X", getX());
        getGPanel().getDynamicValues().putParameterInt("Y", getY());
    }
}
