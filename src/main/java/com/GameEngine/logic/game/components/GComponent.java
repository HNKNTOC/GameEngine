package com.GameEngine.logic.game.components;

import com.GameEngine.logic.game.dynamicValues.Dynamic;
import com.GameEngine.logic.game.id.HasID;

/**
 * Интерфейс для всех игровых объектов которые должны отображаться на GBoard.
 * Каждый GComponent должен иметь GPanel которая будет отображать этот GComponent.
 */
public interface GComponent<GPanel> extends Dynamic, HasID {

    /**
     * Возвращает GPanel который будет отображать данный GComponent.
     * @return GPanel.
     */
    GPanel getGPanel();

    /**
     * Установить GPanel.
     * @param gPanel GPanel который будет отображать данный GComponent.
     */
    void setGPanel(GPanel gPanel);

}
