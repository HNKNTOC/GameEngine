package logic.gameComponents.gPanel.cell;

import logic.gameComponents.boardComponents.gCell.GCell;

import java.awt.*;

/**
 * Created by Nikita on 16.02.2016.
 */
public class GPanelCellInf extends GPanelCell {
    private GCell gCell;

    public GPanelCellInf(GCell gCell) {
        super();
        this.gCell = gCell;
        setColor(Color.RED);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("X="+gCell.getX() + ";" +"Y="+gCell.getY(),5,15);

        g.setColor(getColor());
        g.drawLine(0, 0, getWidth(), 0);
        g.drawLine(0, 0, 0,getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
