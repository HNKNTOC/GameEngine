package logic;

import logic.gameComponents.boardComponents.FactoryGBoard;
import logic.gameComponents.boardComponents.FactoryGBoardDefault;
import logic.gameComponents.boardComponents.GBoard;
import logic.gameComponents.gCell.FactoryGCell;
import logic.gameComponents.gCell.FactoryGCellDefault;
import logic.gameComponents.gCell.GCell;
import logic.gameComponents.gObject.GObject;
import logic.listeners.keyboard.KeyListenerMainPlayer;
import logic.listeners.mouse.MouseListenerDefault;
import logic.moveLogic.MoveObject;
import logic.resources.loader.image.ImageLoader;
import logic.resources.manager.ResManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nikita on 16.02.2016.
 */
public class MainStart {
    public static void main(String[] args){
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
        gObject.setMove(new MoveObject(gObject, gBoard.getListGCell()));
        gBoard.getListGCell().get(3,3).setGObject(gObject);


        JFrame frame = new JFrame();


        frame.add(gBoard.getGPanel());

        frame.addKeyListener(new KeyListenerMainPlayer(gObject.getMove()));

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


        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
