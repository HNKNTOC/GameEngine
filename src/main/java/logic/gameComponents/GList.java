package logic.gameComponents;


/**
 * Интерфейс для удобного хранения GComponents.
 */
public interface GList<GComponent> extends Iterable<GComponent>  {

    /**
     * Получить количество GComponent.
     * @return количество GComponent находящихся в GList.
     */
    int size();


}
