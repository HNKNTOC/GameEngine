package com.GameEngine.logic.listeners.keyboard;


import com.GameEngine.logic.game.action.command.ActionCommand;
import com.GameEngine.logic.game.action.command.gObject.command.CommandMoveDefault;
import com.GameEngine.logic.game.components.gObject.GObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Отвественен за передвежения
 */
public class KeyListenerMainPlayer implements KeyListener {

    private static final Logger logger = LogManager.getLogger(KeyListenerMainPlayer.class);
    private GObject gObject;

    public KeyListenerMainPlayer(GObject gObject) {
        this.gObject = gObject;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ActionCommand actionCommand = gObject.getReceiverAction().getActionCommand(0);
        logger.debug("Click "+e.getKeyCode());
        int x = gObject.getX();
        int y = gObject.getY();

        actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_X, x);
        actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_Y, y);
        actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.COMMAND_ENABLE, 1);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_Y, y - 1);
                break;
            case KeyEvent.VK_DOWN:
                actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_Y, y + 1);
                break;
            case KeyEvent.VK_LEFT:
                actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_X, x - 1);
                break;
            case KeyEvent.VK_RIGHT:
                actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.NAME_PARAMETER_X, x + 1);
                break;
            default:
                actionCommand.getDynamicValues().putParameterInt(CommandMoveDefault.COMMAND_ENABLE, 0);
        }
        actionCommand.execute();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
