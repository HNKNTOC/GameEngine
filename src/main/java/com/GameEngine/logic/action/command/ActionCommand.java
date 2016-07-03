package com.GameEngine.logic.action.command;

import com.GameEngine.logic.dynamicValues.Dynamic;

/**
 * Интервейс для всех команд.
 * Интерфейс предназначен для инкапсуляции запроса на выполнения команды.
 */
public interface ActionCommand extends Dynamic {
    /**
     * Выполнить команду.
     */
    boolean execute();
}
