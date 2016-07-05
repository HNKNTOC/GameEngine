package com.GameEngine.gui.gPanel.cell;

import com.GameEngine.logic.game.components.gCell.GCell;

import java.awt.*;

/**
 * GPanelCellInf показывает дополнительную информацию о gCell графически.
 * (Используется в основном во время разработки).
 */
public class GPanelCellInf extends GPanelCell {
    private GCell gCell;
    public GPanelCellInf(GCell gCell) {
        super(gCell.getId());
        this.gCell = gCell;
        getDynamicValues().putParameterInt("Color", 0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("X="+gCell.getX() + ";" +"Y="+gCell.getY(),5,15);


        g.setColor(parsingColor());
        g.drawLine(0, 0, getWidth(), 0);
        g.drawLine(0, 0, 0,getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Получает цвет из динамического параметра Color.
     * 0 - red 1 - blue
     */
    private Color parsingColor() {
        String color = getDynamicValues().getParameter("Color");
        if (color == null) {
            return Color.GREEN;
        }
        int i = Integer.parseInt(color);
        if (i == 0) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }
}
