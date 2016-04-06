package com.GameEngine.logic.listeners.keyboard;


import com.GameEngine.logic.action.command.ReceiverAction;
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
        ReceiverAction receiver = gObject.getReceiverAction();
        logger.debug("Click "+e.getKeyCode());

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                receiver.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION,CommandMove.ACTION_MOVE_UP,0);
                break;
            case KeyEvent.VK_DOWN:
                receiver.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION,CommandMove.ACTION_MOVE_DOWN,0);
                break;
            case KeyEvent.VK_LEFT:
                receiver.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION,CommandMove.ACTION_MOVE_LEFT,0);
                break;
            case KeyEvent.VK_RIGHT:
                receiver.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION,CommandMove.ACTION_MOVE_RIGHT,0);
                break;
            default: receiver.setParameters(CommandMove.NAME_PARAMETER_ID_ACTION,"0",0);
        }
        receiver.executeCommand(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
