package com.GameEngine.logic.listeners.keyboard;


import com.GameEngine.logic.action.command.ActionCommand;
import com.GameEngine.logic.action.command.gObject.command.CommandMove;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                actionCommand.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION, CommandMove.ACTION_MOVE_UP);
                break;
            case KeyEvent.VK_DOWN:
                actionCommand.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION, CommandMove.ACTION_MOVE_DOWN);
                break;
            case KeyEvent.VK_LEFT:
                actionCommand.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION, CommandMove.ACTION_MOVE_LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                actionCommand.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION, CommandMove.ACTION_MOVE_RIGHT);
                break;
            default:
                actionCommand.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION, "0");
        }
        actionCommand.execute();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
