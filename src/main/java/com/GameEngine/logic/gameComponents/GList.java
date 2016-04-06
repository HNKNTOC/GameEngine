package com.GameEngine.logic.gameComponents;


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
