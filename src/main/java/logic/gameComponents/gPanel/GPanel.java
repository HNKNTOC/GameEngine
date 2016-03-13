package logic.gameComponents.gPanel;
import logic.resources.manager.ResManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Супер класс для всех GPanel.
 * Настраивает JPanel для отрисовки GameComponent.
 */
public class GPanel extends JPanel {
    private ImageIcon image;
    private static final Logger logger = LogManager.getLogger(GPanel.class);

    public GPanel() {
        image = ResManager.getResManager().getImageIcon(0);
        logger.info("Create "+this.toString());
    }

    public GPanel(ImageIcon image) {
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
            g.drawImage(image.getImage(),0,0,getWidth(),getHeight(),null);
        }else {
            logger.warn("paintComponent image!=null");
        }
    }

    @Override
    public String toString() {
        return "GPanel{" +
                "image=" + image +
                '}';
    }
}
