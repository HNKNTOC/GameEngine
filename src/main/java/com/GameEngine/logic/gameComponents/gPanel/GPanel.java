package com.GameEngine.logic.gameComponents.gPanel;

import com.GameEngine.logic.dynamicValues.Dynamic;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import com.GameEngine.logic.id.HasID;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.manager.ResManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Супер класс для всех GPanel.
 * Настраивает JPanel для отрисовки GComponentAbstract.
 */
public class GPanel extends JPanel implements Dynamic, HasID {
    private ImageIcon image;
    private static final Logger logger = LogManager.getLogger(GPanel.class);

    private DynamicParameter parameter;
    /**
     * Уникальный id.
     */
    private final int id;

    public GPanel(int id) {
        this(ResManager.getResManager().getImageIcon(ImageName.NULL), id);
    }

    public GPanel(ImageIcon image, int id) {
        this.id = id;
        this.parameter = new DynamicParameterMap(this.id);
        this.image = image;
        logger.info("Create "+this.toString());
    }

    public ImageIcon getImageIcon() {
        logger.debug("getImageIcon = "+image);
        return image;
    }

    public void setImageIcon(ImageIcon image) {
        this.image = image;
        logger.debug("setImageIcon = "+image);
    }


    @Override
    protected void paintComponent(Graphics g) {
        if (image!=null) {
            logger.debug("paintComponent = "+image);
            g.drawImage(image.getImage(),0,0,getWidth(),getHeight(),null);
        }else {
            logger.warn("paintComponent image!=null");
        }
    }

    @Override
    public DynamicParameter getDynamicValues() {
        return parameter;
    }

    @Override
    public String toString() {
        return "GPanel{" +
                "id=" + id +
                ", image=" + image +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }
}
