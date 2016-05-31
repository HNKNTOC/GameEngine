package com.GameEngine.logic.action.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Реализация через HashMap.
 */
public class ReceiverHashMap implements ReceiverAction {
    private static final Logger LOGGER = LogManager.getLogger(ReceiverHashMap.class);
    private HashMap<Integer,ActionCommand> map;

    public ReceiverHashMap() {
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
        if (actionCommand != null) {
            LOGGER.debug("getActionCommand slot = " + slot + " return " + actionCommand.toString());
        } else {
            LOGGER.info("getActionCommand slot = " + slot + " return CommandDefault");
            actionCommand = new CommandDefault();
        }
        return actionCommand;
    }

    @Override
    public String toString() {
        return "ReceiverHashMap{" +
                "map=" + map +
                '}';
    }
}
