package com.GameEngine.logic.action.command;

import java.util.HashMap;

/**
 * Базовый класс для всех CommandGObject.
 */
public abstract class CommandGObject implements ActionCommand {
    /**
     * Имя параметра. Если параметр содержит 0 команда не выполняется.
     */
    public static final String NAME_PARAMETER_COMMAND_ENABLE = "CommandEnable";
    /**
     * Хранит имя параметра и его значение.
     */
    private HashMap<String,String> mapParameter;

    public CommandGObject() {
        mapParameter = new HashMap<>();
        addNewParameter(NAME_PARAMETER_COMMAND_ENABLE, 1 + "");
    }

    @Override
    public boolean execute() {
        return checkEnable();
    }

    /**
     * Проверяед можно ли выполнить команду.
     *
     * @return false если нет true если да.
     */
    private boolean checkEnable() {
        int enable = Integer.parseInt(getValue(NAME_PARAMETER_COMMAND_ENABLE));
        return enable != 0;
    }

    /**
     * Добавляет новый параметр для команды.
     * @return true если параметр был удачно добавлен.
     */
    protected boolean addNewParameter(String nameParameters, String valueDefault){
        mapParameter.put(nameParameters,valueDefault);
        return false;
    }

    protected String getValue(String nameParameters){
        return mapParameter.get(nameParameters);
    }

    @Override
    public boolean setParameters(String nameParameters, String value) {
        if(mapParameter.containsKey(nameParameters)) {
            mapParameter.put(nameParameters, value);
            return true;
        }
        return false;
    }
}
