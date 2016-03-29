package logic.gameComponents;

import logic.gameComponents.generator.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Супер класс для всех игровых объектов которые должны отображаться на GBoard.
 * Каждый GComponent должен иметь GPanel которая будет отображать этот GComponent.
 */
public abstract class GComponent<GPanel>{
    private static final Logger logger = LogManager.getLogger(GComponent.class);
    /**
     * Панель которая будет отображать игровой компонент.
     */
    private GPanel gPanel;

    /**
     * Id уникальный код для всех GComponent
     */
    private int id;

    /**
     * Создание GComponent
     */
    public GComponent() {
        generateId();
        logger.info("Create "+this.toString());
    }

    /**
     * Создание GComponent с переменными параметрами.
     * @param gPanel которая будет отображать данный GComponent.
     */
    public GComponent(GPanel gPanel) {
        generateId();
        this.gPanel = gPanel;
        logger.info("Create "+this.toString());
    }

    public int getId() {
        return id;
    }

    public GPanel getGPanel() {
        logger.debug("getGPanel "+gPanel);
        return gPanel;
    }

    public void setGPanel(GPanel gPanel) {
        logger.debug("setGPanel "+gPanel);
        this.gPanel = gPanel;
    }

    private void generateId(){
        id = GeneratorId.generateId();
        logger.debug("generateId ="+id);
    }

    @Override
    public boolean equals(Object o) {
        return getClass() == o.getClass() && (this.id == o.hashCode());
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "GComponent{" +
                "id=" + id +
                ", gPanel=" + gPanel +
                '}';
    }
}
