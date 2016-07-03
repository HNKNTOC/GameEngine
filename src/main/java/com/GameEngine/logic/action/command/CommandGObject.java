package com.GameEngine.logic.action.command;

import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.id.HasID;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Базовый класс для всех CommandGObject.
 */
public abstract class CommandGObject implements ActionCommand, HasID {
    private static final Logger LOGGER = LogManager.getLogger(CommandGObject.class);
    /**
     * Имя параметра. Если параметр содержит 0 команда не выполняется.
     */
    public static final String COMMAND_ENABLE = "CommandEnable";
    /**
     * Хранит имя параметра и его значение.
     */
    protected DynamicParameterMap dynamicParameter;
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
        dynamicParameter = new DynamicParameterMap(getId());
        dynamicParameter.putParameterInt(COMMAND_ENABLE, 1);
        LOGGER.info("Create " + toString());
    }

    public GObject getGObject() {
        LOGGER.debug("getGObject " + object.toString());
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
        int enable = dynamicParameter.getParameterInt(COMMAND_ENABLE);
        LOGGER.debug("checkEnable COMMAND_ENABLE= " + enable);
        return enable != 0;
    }

    @Override
    public int getId() {
        return getGObject().getId();
    }

    @Override
    public DynamicParameter getDynamicValues() {
        return dynamicParameter;
    }

    @Override
    public String toString() {
        return "CommandGObject{" +
                "dynamicParameter=" + dynamicParameter +
                ", object=" + object +
                ", board=" + board +
                ", id=" + getId() +
                '}';
    }
}
