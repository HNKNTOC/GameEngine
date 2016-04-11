package com.GameEngine.logic.action.command.gObject.command;

import com.GameEngine.logic.action.command.CommandGObject;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Базовый клаас для комманд на передвижение.
 */
public abstract class CommandMoveAbstract extends CommandGObject {

    /**
     * Имя параметра. Параметр содержит максимальное значение x.
     */
    public static final String NAME_PARAMETER_MAX_X = "maxX";
    /**
     * Имя параметра. Параметр содержит максимальное значение Y.
     */
    public static final String NAME_PARAMETER_MAX_Y = "maxY";
    /**
     * Имя параметра. Параметр содержит X на который нужно передвинуть gObject.
     */
    public static final String NAME_PARAMETER_X = "X";
    /**
     * Имя параметра. Параметр содержит Y на который нужно передвинуть gObject.
     */
    public static final String NAME_PARAMETER_Y = "Y";

    /**
     * Объект который должен совершить действие.
     */
    protected GObject gObject;
    /**
     * Доска на которой содержится gObject.
     */
    protected GBoard gBoard;

    /**
     * @param gObject gObject который должен совершить действие.
     * @param gBoard  gBoard на которой содержится gObject.
     */
    public CommandMoveAbstract(GObject gObject, GBoard gBoard) {
        this.gObject = gObject;
        this.gBoard = gBoard;
        addNewParameter(NAME_PARAMETER_MAX_X, 0 + "");
        addNewParameter(NAME_PARAMETER_MAX_Y, 0 + "");
        addNewParameter(NAME_PARAMETER_X, 0 + "");
        addNewParameter(NAME_PARAMETER_Y, 0 + "");
    }

    @Override
    public boolean execute() {
        if (!checkEnable()) {
            return false;
        }
        final int oldX = gObject.getX();
        final int oldY = gObject.getY();
        int x = Integer.parseInt(getValue(NAME_PARAMETER_X));
        int y = Integer.parseInt(getValue(NAME_PARAMETER_Y));

        if (!check(x, y)) return false;
        move(x, y, oldX, oldY);
        return true;
    }

    /**
     * Передвигает gObject из одних клетки в другую.
     *
     * @param x    координата клетки в которую нужно передвинуть.
     * @param y    координата клетки в которую нужно передвинуть.
     * @param oldX координата клетки из которой нужно передвинуть gObject.
     * @param oldY координата клетки из которой нужно передвинуть gObject.
     */
    protected void move(int x, int y, int oldX, int oldY) {
        GCell oldCell = gBoard.getListGCell().get(oldX, oldY);
        GCell newCell = gBoard.getListGCell().get(x, y);
        oldCell.setGObject(null);
        newCell.setGObject(gObject);
        gObject.setX(x);
        gObject.setY(y);
    }

    /**
     * Проверяет превышает ли x и y максимум и уходят ли они в минус.
     *
     * @return false если sizeColumn или sizeRows превышают максимум или уходят в минус.
     */
    protected abstract boolean check(int x, int y);

}
