package logic.gameComponents.gPanel;


import logic.resources.manager.ResManager;

import javax.swing.*;
import java.awt.*;

/**
 * Супер класс для всех GPanel.
 * Настраивает JPanel для отрисовки GameComponent.
 */
public class GPanel extends JPanel {
    private int idImage;

    public GPanel() {
        idImage = 0;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image image = ResManager.getResManager().getImageIcon(idImage).getImage();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
    }

    @Override
    public String toString() {
        return "GPanel{" +
                "idImage=" + idImage +
                '}';
    }
}
