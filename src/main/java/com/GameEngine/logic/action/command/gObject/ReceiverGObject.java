package com.GameEngine.logic.action.command.gObject;

import com.GameEngine.logic.action.command.ActionCommand;
import com.GameEngine.logic.action.command.ReceiverAction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Реализация для GObject.
 */
public class ReceiverGObject implements ReceiverAction {
    private static final Logger LOGGER = LogManager.getLogger(ReceiverGObject.class);
    private HashMap<Integer,ActionCommand> map;

    public ReceiverGObject() {
        map = new HashMap<>();
        LOGGER.info("Create " + toString());
    }

    @Override
    public boolean setActionCommand(ActionCommand command, int slot) {
        LOGGER.debug("setActionCommand command = " + command.toString() + " slot = " + slot);
        map.put(slot,command);
        return true;
    }

    @Override
    public ActionCommand getActionCommand(int slot) {
        ActionCommand actionCommand = map.get(slot);
        LOGGER.debug("getActionCommand slot = " + slot + " return " + actionCommand.toString());
        return actionCommand;
    }

    @Override
    public String toString() {
        return "ReceiverGObject{" +
                "map=" + map +
                '}';
    }
}
