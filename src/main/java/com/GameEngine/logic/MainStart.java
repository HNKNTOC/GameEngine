package com.GameEngine.logic;

import com.GameEngine.gui.Display;
import com.GameEngine.gui.JDisplay;
import com.GameEngine.logic.action.command.ReceiverAction;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.action.command.gObject.command.CommandMove;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.GPanelDefaultFactory;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCellFactory;
import com.GameEngine.logic.listeners.keyboard.KeyListenerMainPlayer;
import com.GameEngine.logic.listeners.mouse.MouseListenerDefault;
import com.GameEngine.logic.resources.LoaderLog4jConfig;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import com.GameEngine.logic.resources.manager.ResManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nikita on 16.02.2016.
 */
public class MainStart {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;

        LoaderLog4jConfig.loadConfig();


        //Загрузка Image
        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage("null.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("grass.jpg"));
        resManager.putImageIcon(ImageLoader.getImage("Player.png"));

        //Создание и заполнение listGCell
        MouseListenerDefault listener = new MouseListenerDefault();
        GCellFactory GCellFactory = new GCellFactoryDefault(new GPanelCellFactory());
        ListGCell<GCell> listGCell = new HashMapPanelGCell(x,y);
        for (GCell gCell : GCellFactory.createGCell(x * y)) {
            gCell.getGPanel().addMouseListener(listener);
            listGCell.add(gCell);
        }


        GBoardFactory GBoardFactory = new GBoardFactoryDefault(new GPanelDefaultFactory());
        GBoard gBoard = GBoardFactory.createGBoard(listGCell);


        GObject player = new GObject();
        gBoard.getListGCell().get(5,5).setGObject(player);
        player.setX(5);
        player.setY(5);

        //Создание и настройка команды.
        CommandMove commandMove = new CommandMove(player,gBoard);
        commandMove.setParameters(CommandMove.NAME_PARAMETER_MAX_X_MOVE,gBoard.getListGCell().getMaxX()+"");
        commandMove.setParameters(CommandMove.NAME_PARAMETER_MAX_Y_MOVE,gBoard.getListGCell().getMaxY()+"");

        ReceiverAction receiver = new ReceiverGObject();
        receiver.addActionCommand(commandMove,0);
        player.setReceiverAction(receiver);

        Display display = new JDisplay();

        display.addKeyListener(new KeyListenerMainPlayer(player));
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32){
                    gBoard.updateGCell();
                }
                if(e.getKeyCode()==66){
                    gBoard.getGPanel().repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        display.showPanel(gBoard.getGPanel());
        display.start();
        gBoard.getGPanel().setImageIcon(null);
        gBoard.updateGCell();
    }
}
