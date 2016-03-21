import gui.Display;
import gui.JDisplay;
import logic.gameComponents.boardComponents.gBoard.FactoryGBoard;
import logic.gameComponents.boardComponents.gBoard.FactoryGBoardDefault;
import logic.gameComponents.boardComponents.gBoard.GBoard;
import logic.gameComponents.boardComponents.gCell.FactoryGCell;
import logic.gameComponents.boardComponents.gCell.FactoryGCellDefault;
import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.boardComponents.gObject.GObject;
import logic.listeners.mouse.MouseListenerDefault;
import logic.resources.loader.image.ImageLoader;
import logic.resources.manager.ResManager;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nikita on 16.02.2016.
 */
public class TestGamePanel {
    @Test
    public void test(){

        int x = 10;
        int y = 10;

        FactoryGBoard factoryGBoard = new FactoryGBoardDefault();
        GBoard gBoard = factoryGBoard.createGBoard(x,y);

        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage("null.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("grass.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("Player.png"));

        MouseListenerDefault listener = new MouseListenerDefault();
        FactoryGCell factoryGCell = new FactoryGCellDefault();
        for (GCell gCell : factoryGCell.createGCell(x * y)) {
            gCell.getGPanel().addMouseListener(listener);
            gBoard.getListGCell().add(gCell);
        }

        GObject gObject = new GObject();
        //gObject.setReceiverAction(new ReceiverActionObject(gObject, gBoard.getListGCell()));
        gBoard.getListGCell().get(3,3).setGObject(gObject);


        JFrame frame = new JFrame();


        frame.add(gBoard.getGPanel());

        //frame.addKeyListener(new KeyListenerMainPlayer(gObject.getReceiverAction()));

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                frame.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        Display display = new JDisplay();
        display.showPanel(gBoard.getGPanel());
        display.start();
    }

}
