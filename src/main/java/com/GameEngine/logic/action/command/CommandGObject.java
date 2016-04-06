package com.GameEngine.logic.action.command;

import java.util.HashMap;

/**
 * Базовый класс для всех CommandGObject.
 */
public abstract class CommandGObject implements ActionCommand {
    /**
     * Хранит имя параметра и его значение.
     */
    private HashMap<String,String> mapParameter;

    public CommandGObject() {
        mapParameter = new HashMap<>();
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
