package com.GameEngine.logic.game.action.command;

import com.GameEngine.logic.game.dynamicValues.Dynamic;

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
