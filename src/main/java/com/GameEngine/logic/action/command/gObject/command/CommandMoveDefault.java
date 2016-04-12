package com.GameEngine.logic.action.command.gObject.command;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Данная реализация CommandGObject передвигает объект на одну клетку (вверх,вниз,влево,вправо).
 */
public class CommandMoveDefault extends CommandMoveAbstract {

    public CommandMoveDefault(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected boolean check(int x, int y) {
        return true;
    }
}
