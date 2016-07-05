package com.GameEngine.logic.game.action.command.gObject.command;

import com.GameEngine.logic.game.action.command.CommandGObject;
import com.GameEngine.logic.game.components.gBoard.GBoard;
import com.GameEngine.logic.game.components.gCell.GCell;
import com.GameEngine.logic.game.components.gObject.GObject;
import com.GameEngine.logic.game.dynamicValues.DynamicParameter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Базовый клаас для комманд на передвижение.
 */
public abstract class CommandMoveGObject extends CommandGObject {
    private static final Logger LOGGER = LogManager.getLogger(CommandMoveGObject.class);

    private final int maxX;
    private final int maxY;
    /**
     * Имя параметра.
     * Количество ходов.
     */

    public static final String NAME_PARAMETER_X = "X";
    /**
     * Имя параметра. Параметр содержит Y на который нужно передвинуть object.
     */
    public static final String NAME_PARAMETER_Y = "Y";


    /**
     * @param object object который должен совершить действие.
     * @param board  board на которой содержится object.
     */
    public CommandMoveGObject(GObject object, GBoard board) {
        super(object, board);
        maxX = board.getListGCell().getMaxX();
        maxY = board.getListGCell().getMaxY();
        dynamicParameter.putParameterInt(NAME_PARAMETER_X, 0);
        dynamicParameter.putParameterInt(NAME_PARAMETER_Y, 0);
        LOGGER.info("Create " + toString());
    }

    @Override
    public boolean execute() {
        if (!super.execute()) {
            LOGGER.debug("execute return false");
            return false;
        }
        final int oldX = object.getX();
        final int oldY = object.getY();
        int x = dynamicParameter.getParameterInt(NAME_PARAMETER_X);
        int y = dynamicParameter.getParameterInt(NAME_PARAMETER_Y);

        if (!(checkMove(x, y) & checkMaxCoordinate(x, y))) {
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
        incrementMove();
    }

    /**
     * Проверяет выходит ли x за рамки поля.
     *
     * @param x координату x которую нужно проверить.
     * @return false если координата выходит за рамки поля.
     */
    protected boolean checkMaxX(int x) {
        if (x < maxX & x >= 0) {
            return true;
        } else {
            LOGGER.info("checkMaxX false for " + x);
            return false;
        }
    }

    /**
     * Проверяет выходит ли y за рамки поля.
     *
     * @param y координату y которую нужно проверить.
     * @return false если координата выходит за рамки поля.
     */
    protected boolean checkMaxY(int y) {
        if (y < maxY & y >= 0) {
            return true;
        } else {
            LOGGER.info("checkMaxY false for " + y);
            return false;
        }
    }

    /**
     * Проверка превышает ли x и y максимального значения.
     *
     * @param x координата клетки x.
     * @param y координата клетки y.
     * @return false если x или y превышает максимальное значения.
     */
    private boolean checkMaxCoordinate(int x, int y) {
        return checkMaxX(x) & checkMaxY(y);
    }

    /**
     * Проверяет можно ли передвинуть object на новые координаты.
     *
     * @param x координата на которую нужно передвинуть object.
     * @param y ордината на которую нужно передвинуть object.
     * @return false если sizeColumn или sizeRows превышают максимум или уходят в минус.
     */
    protected abstract boolean checkMove(int x, int y);

    /**
     * Прибавляет 1 к параметру NUMBER_MOVE.
     * incrementMove() должен выполнятся при каждом перемещении.
     */
    private void incrementMove() {
        DynamicParameter dynamicValues = object.getDynamicValues();
        int parameterInt = dynamicValues.getParameterInt(GObject.NUMBER_MOVE);
        parameterInt++;
        dynamicValues.putParameterInt(GObject.NUMBER_MOVE, parameterInt);
        LOGGER.debug("incrementMove NUMBER_MOVE = " + parameterInt);
    }
}
