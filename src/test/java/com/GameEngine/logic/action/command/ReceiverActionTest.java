package com.GameEngine.logic.action.command;

import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveDefault;
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
        CommandMoveDefault command = new CommandMoveDefault(null, null);
        int slot = new Random().nextInt();
        receiverAction.setActionCommand(command, slot);
        assertTrue(receiverAction.getActionCommand(slot) == command);
        assertTrue(receiverAction.getActionCommand(slot - 1) == null);
    }

}