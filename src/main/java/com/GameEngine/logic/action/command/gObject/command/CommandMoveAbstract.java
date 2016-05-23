package com.GameEngine.logic.action.command.gObject.command;

import com.GameEngine.logic.action.command.CommandGObject;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Базовый клаас для комманд на передвижение.
 */
public abstract class CommandMoveAbstract extends CommandGObject {
    private static final Logger LOGGER = LogManager.getLogger(CommandMoveAbstract.class);

    private final int maxX;
    private final int maxY;
    /**
     * Имя параметра. Параметр содержит X на который нужно передвинуть object.
     */
    public static final String NAME_PARAMETER_X = "X";
    /**
     * Имя параметра. Параметр содержит Y на который нужно передвинуть object.
     */
    public static final String NAME_PARAMETER_Y = "Y";

    /**
     * Объект который должен совершить действие.
     */
    private final GObject object;
    /**
     * Доска на которой содержится object.
     */
    private final GBoard board;

    /**
     * @param object object который должен совершить действие.
     * @param board  board на которой содержится object.
     */
    public CommandMoveAbstract(GObject object, GBoard board) {
        this.object = object;
        this.board = board;
        maxX = board.getListGCell().getMaxX();
        maxY = board.getListGCell().getMaxY();
        addNewParameter(NAME_PARAMETER_X, 0 + "");
        addNewParameter(NAME_PARAMETER_Y, 0 + "");
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

    @Override
    public boolean execute() {
        if (!super.execute()) {
            LOGGER.debug("execute return false");
            return false;
        }
        final int oldX = object.getX();
        final int oldY = object.getY();
        int x = Integer.parseInt(getValue(NAME_PARAMETER_X));
        int y = Integer.parseInt(getValue(NAME_PARAMETER_Y));

        if (!(check(x, y) & checkMaxX(x) & checkMaxY(y))) {
            LOGGER.debug("execute excess max x or y return false!");
            return false;
        }
        move(x, y, oldX, oldY);
        LOGGER.debug("execute return true");
        return true;
    }

    /**
     * Передвигает object из одних клетки в другую.
     *
     * @param x    координата клетки в которую нужно передвинуть.
     * @param y    координата клетки в которую нужно передвинуть.
     * @param oldX координата клетки из которой нужно передвинуть object.
     * @param oldY координата клетки из которой нужно передвинуть object.
     */
    protected void move(int x, int y, int oldX, int oldY) {
        LOGGER.info("move from (" + x + ";" + y + ") to (" + oldX + ";" + oldY + ")");
        GCell oldCell = board.getListGCell().get(oldX, oldY);
        GCell newCell = board.getListGCell().get(x, y);
        oldCell.setGObject(null);
        newCell.setGObject(object);
        object.setX(x);
        object.setY(y);
        oldCell.getGPanel().repaint();
        newCell.getGPanel().repaint();
    }

    /**
     * Проверяет выходит ли x за рамки поля.
     *
     * @param x координату x которую нужно проверить.
     * @return false если координата выходит за рамки поля.
     */
    protected boolean checkMaxX(int x) {
        return x < maxX & x >= 0;
    }

    /**
     * Проверяет выходит ли y за рамки поля.
     *
     * @param y координату y которую нужно проверить.
     * @return false если координата выходит за рамки поля.
     */
    protected boolean checkMaxY(int y) {
        return y < maxY & y >= 0;
    }

    /**
     * Проверяет можно ли передвинуть object на новые координаты.
     *
     * @param x координата на которую нужно передвинуть object.
     * @param y ордината на которую нужно передвинуть object.
     * @return false если sizeColumn или sizeRows превышают максимум или уходят в минус.
     */
    protected abstract boolean check(int x, int y);

}
