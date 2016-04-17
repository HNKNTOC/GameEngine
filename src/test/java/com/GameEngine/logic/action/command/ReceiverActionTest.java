package com.GameEngine.logic.action.command;

import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 11.04.2016.
 */
public class ReceiverActionTest {
    @Test
    public void setAndGetActionCommand() throws Exception {
        ReceiverAction receiverAction = new ReceiverGObject();
        CommandMoveDefault command = new CommandMoveDefault(new GObject(), new GBoard(1, 1));
        int slot = new Random().nextInt();
        receiverAction.setActionCommand(command, slot);
        assertTrue(receiverAction.getActionCommand(slot) == command);
        assertTrue(receiverAction.getActionCommand(slot - 1) == null);
    }

}