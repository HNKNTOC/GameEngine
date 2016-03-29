import gui.JDisplay;
import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.gameComponents.gPanel.GPanel;
import logic.gameComponents.gPanel.cell.GPanelCell;
import logic.resources.loader.image.ImageLoader;
import logic.resources.manager.ResManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nikita on 30.03.2016.
 */
public class TestGPanelCell {
    public static void main(String[] args) {
        //Загрузка Image
        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage("null.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("grass.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("Player.png"));

        GCell cell = new GCell();
        cell.setGPanel(new GPanelCell());
        cell.getGPanel().setImageIcon(ImageLoader.getImage("grass.jpg"));

        GObject player = new GObject();
        player.getGPanel().setImageIcon(ImageLoader.getImage("Player.png"));

        cell.setGObject(player);

        JDisplay jDisplay = new JDisplay();
        jDisplay.showPanel(cell.getGPanel());
        jDisplay.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32){
                    cell.setGObject(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        jDisplay.start();
    }
}
