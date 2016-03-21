package logic.gameComponents.gPanel.cell;

import logic.gameComponents.boardComponents.gCell.GCell;
import logic.gameComponents.gPanel.GPanel;

import java.awt.*;

/**
 * Created by Nikita on 16.02.2016.
 */
public class GCellPanel extends GPanel {

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected GCell gCell;

    public GCellPanel(GCell gCell) {
        this.gCell = gCell;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(gCell.getGObject()!=null){
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5,5,5,5);
            c.weightx = 1;
            c.weighty = 1;
            c.fill = GridBagConstraints.BOTH;
            add(gCell.getGObject().getGPanel(),c);
        }
    }
}
