package com.GameEngine.logic.action.command;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Базовый класс для всех CommandGObject.
 */
public abstract class CommandGObject implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(CommandGObject.class);
    /**
     * Имя параметра. Если параметр содержит 0 команда не выполняется.
     */
    public static final String COMMAND_ENABLE = "CommandEnable";
    /**
     * Хранит имя параметра и его значение.
     */
    private HashMap<String, String> mapParameter;
    /**
     * Объект который должен совершить действие.
     */
    protected final GObject object;
    /**
     * Доска на которой содержится object.
     */
    protected final GBoard board;

    public CommandGObject(GObject object, GBoard board) {
        this.object = object;
        this.board = board;
        mapParameter = new HashMap<>();
        addNewParameter(COMMAND_ENABLE, 1 + "");
        LOGGER.info("Create " + toString());
    }

    public GObject getObject() {
        LOGGER.debug("getObject " + object.toString());
        return object;
    }

    public GBoard getBoard() {
        LOGGER.debug("getBoard " + board.toString());
        return board;
    }

    /**
     * Выполнить команду.
     */
    @Override
    public boolean execute() {
        boolean b = checkEnable();
        LOGGER.debug("execute return " + b);
        return b;
    }

    /**
     * Проверяед можно ли выполнить команду.
     *
     * @return false если нет true если да.
     */
    private boolean checkEnable() {
        int enable = Integer.parseInt(getValue(COMMAND_ENABLE));
        LOGGER.debug("checkEnable COMMAND_ENABLE= " + COMMAND_ENABLE);
        return enable != 0;
    }

    /**
     * Добавляет новый параметр для команды.
     *
     * @return true если параметр был удачно добавлен.
     */
    protected boolean addNewParameter(String nameParameters, String valueDefault) {
        LOGGER.debug("addNewParameter nameParameters = " + nameParameters + " valueDefault = " + valueDefault);
        mapParameter.put(nameParameters, valueDefault);
        return true;
    }

    protected String getValue(String nameParameters) {
        String value = mapParameter.get(nameParameters);
        LOGGER.debug("getValue nameParameters = " + nameParameters + " return = " + value);
        return value;
    }

    @Override
    public boolean setParameters(String nameParameters, String value) {
        if (mapParameter.containsKey(nameParameters)) {
            LOGGER.debug("setParameters nameParameters = " + nameParameters + " value = " + value);
            mapParameter.put(nameParameters, value);
            return true;
        }
        LOGGER.debug("setParameters not find nameParameters= " + nameParameters);
        return false;
    }

    @Override
    public String toString() {
        return "CommandGObject{" +
                "mapParameter=" + mapParameter +
                ", object=" + object +
                ", board=" + board +
                '}';
    }
}
