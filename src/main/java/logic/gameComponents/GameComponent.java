package logic.gameComponents;

import logic.gameComponents.gPanel.GPanel;
import logic.gameComponents.generator.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

/**
 * Супер класс для отображения всех игровых компонентов.
 * Каждый GameComponent должен иметь GPanel которая будет отображать этот GameComponent.
 */
public abstract class GameComponent{
    //private static final Logger logger = LogManager.getLogger(GameComponent.class);
    /**
     * Панель которая будет отображать игровой компонент.
     */
    private GPanel gPanel;

    /**
     * Id уникальный код для всех GameComponent
     */
    private int id;

    /**
     * Создание GameComponent с стандартной JPanel.
     */
    public GameComponent() {
        generateId();
        gPanel = new GPanel();
        //logger.info("Create "+this.toString());
    }

    /**
     * Создание GameComponent с переменными параметрами.
     * @param gPanel которая будет отображать данный GameComponent.
     */
    public GameComponent(GPanel gPanel) {
        generateId();
        this.gPanel = gPanel;
        //logger.info("Create "+this.toString());
    }

    public int getId() {
        return id;
    }

    public JPanel getGPanel() {
        //logger.debug(id+".getGPanel("+gPanel+")");
        return gPanel;
    }

    public void setGPanel(GPanel gPanel) {
        //logger.debug(id+".setGPanel("+gPanel+")");
        this.gPanel = gPanel;
    }

    private void generateId(){
        id = GeneratorId.generateId();
    }

    @Override
    public String toString() {
        return "GameComponent{" +
                "id=" + id +
                ", gPanel=" + gPanel +
                '}';
    }
}
