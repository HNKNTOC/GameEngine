package logic.action.command;

/**
 * Интервейс для всех команд.
 * Интерфейс предназначен для инкапсуляции запроса на выполнения команды.
 */
public interface ActionCommand {
    /**
     * Выполнить команду.
     */
    void execute();

    /**
     * Задать параметры для команды.
     * @param nameParameters имя параметра.
     * @param value значение параметра.
     * @return true если параметр был задан успешно.
     *         false если параметр был не найден или неверно задано значение параметра.
     */
    boolean setParameters(String nameParameters,String value);
}
