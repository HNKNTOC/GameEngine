package com.GameEngine.logic.game.action.command.gObject.command;

import com.GameEngine.logic.game.components.gBoard.GBoard;
import com.GameEngine.logic.game.components.gObject.GObject;

/**
 * Данная реализация CommandGObject передвигает объект на одну клетку (вверх,вниз,влево,вправо).
 */
public class CommandMoveDefault extends CommandMoveGObject {

    public CommandMoveDefault(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected boolean checkMove(int x, int y) {
        return true;
    }
}
