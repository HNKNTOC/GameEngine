package logic.action.command;

/**
 * Базовый интерфейс всех Receiver.
 * Хранит ActionCommand в выполняет их.
 */
public interface ReceiverAction{
    /**
     * Добавляет команду.
     * @param command команда.
     * @param slot слот в которую нужно поместить команду.
     * @return true если команда была добавлена успешно.
     *         false если команда не была добавлена.
     */
    boolean addActionCommand(ActionCommand command,int slot);

    /**
     * Выполнить команду находящуюся в заданном слоте.
     * @param slot слот в котором находится команда.
     * @return true если команда была вызвана.
     *         false если слот null.
     */
    boolean executeCommand(int slot);

    /**
     * Задать параметр для команды находящийся в заданном слоте.
     * @param nameParameters имя параметра.
     * @param value значение параметра.
     * @param slot слот в котором находится команда.
     * @return true если параметр был задан успешно.
     *         false если слот null.
     * @throws IncorrectlySetParameter если параметр был не найден или неверно задано значение параметра.
     */
    boolean setParameters(String nameParameters,String value,int slot) throws IncorrectlySetParameter;
}
