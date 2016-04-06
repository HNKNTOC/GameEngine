package logic.action.command.gObject;

import logic.action.command.ActionCommand;
import logic.action.command.IncorrectlySetParameter;
import logic.action.command.ReceiverAction;

import java.util.HashMap;

/**
 * Реализация для GObject.
 */
public class ReceiverGObject implements ReceiverAction {
    private HashMap<Integer,ActionCommand> map;

    public ReceiverGObject() {
        map = new HashMap<>();
    }

    @Override
    public boolean addActionCommand(ActionCommand command, int slot) {
        map.put(slot,command);
        return true;
    }

    @Override
    public boolean executeCommand(int slot) {
            map.get(slot).execute();
        return true;
    }

    @Override
    public boolean setParameters(String nameParameters, String value, int slot) throws IncorrectlySetParameter {
        return map.get(slot).setParameters(nameParameters,value);
    }
}
