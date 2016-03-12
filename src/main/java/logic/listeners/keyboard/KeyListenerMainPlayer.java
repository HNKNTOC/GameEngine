package logic.listeners.keyboard;




import logic.moveLogic.Move;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Отвественен за передвежения
 */
public class KeyListenerMainPlayer implements KeyListener {

    Move move;

    public KeyListenerMainPlayer(Move move) {
        this.move = move;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key=" + e.getKeyCode());

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                move.move(move.getX(),move.getY()-1);
                break;
            case KeyEvent.VK_DOWN:
                move.move(move.getX(), move.getY()+1);
                break;
            case KeyEvent.VK_LEFT:
                move.move(move.getX()-1, move.getY());
                break;
            case KeyEvent.VK_RIGHT:
                move.move(move.getX()+1,move.getY());
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
