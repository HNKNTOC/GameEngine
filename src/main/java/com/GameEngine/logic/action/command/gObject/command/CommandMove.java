package com.GameEngine.logic.action.command.gObject.command;

import com.GameEngine.logic.action.command.CommandGObject;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Created by Nikita on 18.03.2016.
 */
public class CommandMove extends CommandGObject {
    public static final String NAME_PARAMETER_ID_ACTION = "idAction";
    public static final String NAME_PARAMETER_MAX_X_MOVE= "maxX";
    public static final String NAME_PARAMETER_MAX_Y_MOVE= "maxY";
    public static final String ACTION_MOVE_UP = "1";
    public static final String ACTION_MOVE_DOWN = "2";
    public static final String ACTION_MOVE_LEFT = "3";
    public static final String ACTION_MOVE_RIGHT = "4";
    /**
     * Объет который должен совершить действие.
     */
    private GObject gObject;
    private GBoard gBoard;

    public CommandMove(GObject gObject, GBoard gBoard) {
        this.gBoard = gBoard;
        this.gObject = gObject;
        addNewParameter(NAME_PARAMETER_ID_ACTION,0+"");
        addNewParameter(NAME_PARAMETER_MAX_X_MOVE,0+"");
        addNewParameter(NAME_PARAMETER_MAX_Y_MOVE,0+"");
    }

    @Override
    public boolean execute() {
        String id = getValue(NAME_PARAMETER_ID_ACTION);
        int x = gObject.getX();
        int y = gObject.getY();

        switch (id){
            case "0": break;
            case ACTION_MOVE_UP: y--; break;
            case ACTION_MOVE_DOWN: y++; break;
            case ACTION_MOVE_LEFT: x--; break;
            case ACTION_MOVE_RIGHT: x++; break;
        }
        if (check(x,y)) {
            move(x, y);
            return true;
        }
        return false;
    }

    private void move(int x, int y) {
        GCell oldCell = gBoard.getListGCell().get(x, y);
        GCell newCell = gBoard.getListGCell().get(x, y);
        gObject.setX(x);
        gObject.setY(y);
        oldCell.setGObject(null);
        newCell.setGObject(gObject);
    }

    /**
     * Проверяет превышает ли sizeColumn и sizeRows максимум и уходят ли они в минус.
     *
     * @return false если sizeColumn или sizeRows превышают максимум или уходят в минус.
     */
    private boolean check(int x,int y) {
        return (x < Integer.parseInt(getValue(NAME_PARAMETER_MAX_X_MOVE))
                & y < Integer.parseInt(getValue(NAME_PARAMETER_MAX_Y_MOVE))
                & x >= 0 & y >= 0);
    }
}
