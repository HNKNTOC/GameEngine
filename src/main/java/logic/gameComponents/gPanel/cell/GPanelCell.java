package logic.gameComponents.gPanel.cell;

import logic.gameComponents.gPanel.GPanel;

import java.awt.*;

/**
 * Панель для GCell отображает объект находящийся в GCell.
 */
public class GPanelCell extends GPanel {

    private Color color;
    private GPanel gPanelObject;

    public GPanel getGPanelObject() {
        return gPanelObject;
    }

    public void setGPanelObject(GPanel gPanelObject) {
        this.gPanelObject = gPanelObject;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        if(gPanelObject!=null){
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5,5,5,5);
            c.weightx = 1;
            c.weighty = 1;
            c.fill = GridBagConstraints.BOTH;
            add(gPanelObject,c);
        }
    }
}
