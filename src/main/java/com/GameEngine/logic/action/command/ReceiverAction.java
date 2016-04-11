package com.GameEngine.logic.action.command;

/**
 * Базовый интерфейс всех Receiver.
 * Хранит ActionCommand в выполняет их.
 */
public interface ReceiverAction{
    /**
     * Устанавливает в слот команду.
     * @param command команда.
     * @param slot слот в которую нужно поместить команду.
     * @return true если команда была добавлена успешно.
     *         false если команда не была добавлена.
     */
    boolean setActionCommand(ActionCommand command, int slot);

    /**
     * Возвращает ActionCommand.
     * @param slot номер слота в котором лежит ActionCommand.
     * @return ActionCommand соответствующий слоту
     *  null если в слоте нет ActionCommand.
     */
    ActionCommand getActionCommand(int slot);
}
