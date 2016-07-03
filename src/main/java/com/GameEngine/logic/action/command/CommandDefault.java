package com.GameEngine.logic.action.command;

import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Пустая реализация при использовании которой вызывается сообщение в лог об ошибке.
 * Нужен чтоб не возвращать null.
 */
public class CommandDefault implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(CommandDefault.class);

    public CommandDefault() {
        LOGGER.info("Create " + toString());
    }

    @Override
    public boolean execute() {
        LOGGER.warn("execute was caused by the CommandDefault !!");
        return false;
    }

    @Override
    public DynamicParameter getDynamicValues() {
        LOGGER.warn("execute was caused by the CommandDefault !!");
        return new DynamicParameterMap(0);
    }
}
