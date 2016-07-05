package com.GameEngine.logic.game.components;


/**
 * Интерфейс для удобного хранения GComponents.
 */
public interface GList<GComponent> extends Iterable<GComponent>  {

    /**
     * Получить количество GComponentAbstract.
     * @return количество GComponentAbstract находящихся в GList.
     */
    int size();


}
