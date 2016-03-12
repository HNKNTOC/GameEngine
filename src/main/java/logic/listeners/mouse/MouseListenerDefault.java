package logic.listeners.mouse;




import logic.gameComponents.gPanel.cell.GCellPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Обрабатывает нажатия мыши.
 * Оповещает всех ListenerClickCell о том на какой объект нажали.
 */
public class MouseListenerDefault implements MouseListener {

    private GCellPanel thisPanel;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        GCellPanel newPanel  =(GCellPanel) e.getComponent();
        if(thisPanel ==null){
            thisPanel = newPanel;
        }else {
            thisPanel.setColor(Color.RED);
            thisPanel.repaint();
        }
        thisPanel = newPanel;
        thisPanel.setColor(Color.BLUE);
        thisPanel.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
