package com.GameEngine.logic;

import com.GameEngine.gui.Display;
import com.GameEngine.gui.JDisplay;
import com.GameEngine.gui.gPanel.GPanelDefaultFactory;
import com.GameEngine.gui.gPanel.cell.GPanelCellFactory;
import com.GameEngine.logic.game.action.command.ReceiverAction;
import com.GameEngine.logic.game.action.command.ReceiverHashMap;
import com.GameEngine.logic.game.action.command.gObject.command.CommandMoveDefault;
import com.GameEngine.logic.game.components.gBoard.GBoard;
import com.GameEngine.logic.game.components.gBoard.GBoardFactory;
import com.GameEngine.logic.game.components.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gCell.GCellFactory;
import com.GameEngine.logic.game.components.gCell.GCellFactoryDefault;
import com.GameEngine.logic.game.components.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.game.components.gCell.list.ListGCell;
import com.GameEngine.logic.game.components.gObject.GObject;
import com.GameEngine.logic.listeners.keyboard.KeyListenerMainPlayer;
import com.GameEngine.logic.listeners.mouse.MouseListenerDefault;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.LoaderLog4jConfig;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import com.GameEngine.logic.resources.manager.ResManager;

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
        resManager.putImageIcon(ImageLoader.getImage(ImageName.NULL));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.CELL));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.OBJECT));

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
        player.getGPanel().setImageIcon(ResManager.getResManager().getImageIcon(ImageName.OBJECT));
        player.setX(5);
        player.setY(5);

        //Создание и настройка команды.
        CommandMoveDefault commandMoveDefault = new CommandMoveDefault(player, gBoard);

        ReceiverAction receiver = new ReceiverHashMap();
        receiver.setActionCommand(commandMoveDefault, 0);
        player.setReceiverAction(receiver);

        Display display = new JDisplay();

        display.getJFrame().addKeyListener(new KeyListenerMainPlayer(player));

        display.showPanel(gBoard.getGPanel());
        gBoard.getGPanel().setImageIcon(null);
        gBoard.updateGCell();
        display.start();
    }
}
