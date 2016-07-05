import com.GameEngine.gui.JDisplay;
import com.GameEngine.gui.gPanel.cell.GPanelCell;
import com.GameEngine.logic.game.components.gCell.GCellDefault;
import com.GameEngine.logic.game.components.gObject.GObject;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import com.GameEngine.logic.resources.manager.ResManager;

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
        resManager.putImageIcon(ImageLoader.getImage("player.png"));

        GCellDefault cell = new GCellDefault();
        cell.setGPanel(new GPanelCell(cell.getId()));
        cell.getGPanel().setImageIcon(ImageLoader.getImage("grass.jpg"));

        GObject player = new GObject();
        player.getGPanel().setImageIcon(ImageLoader.getImage("player.png"));

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
