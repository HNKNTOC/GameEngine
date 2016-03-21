package logic.gameComponents;
import java.util.Observable;

/**
 * Интерфейс для удобного хранения GComponents.
 */
public abstract class GList<GComponent> extends Observable implements Iterable<GComponent>  {

    /**
     * Получить количество GComponent.
     * @return количество GComponent находящихся в GList.
     */
    abstract public int size();


}
