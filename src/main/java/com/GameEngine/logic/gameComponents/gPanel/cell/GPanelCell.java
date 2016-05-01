package com.GameEngine.logic.gameComponents.gPanel.cell;

import com.GameEngine.logic.dynamicValues.Dynamic;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;

import java.awt.*;

/**
 * Панель для GCellDefault отображает объект находящийся в GCellDefault.
 */
public class GPanelCell extends GPanel implements Dynamic {

    private GPanel gPanelObject;
    /**
     * Имя параметра в DynamicParameterMap.
     * Параметр может иметь два значения 0 или 1.
     *  0 - кружок в центре клетки не виден.
     *  1 - кружок в центре клетки виден.
     *  (В основном используется для обозначения клетки)
     */
    public static final String PARAMETER_NAME_SELECTION = "Selection";
    /**
     * Имя параметра в DynamicParameterMap.
     * В параметре содержится цвет кружка в центре.
     * Цвет нужно указать в формате 10-чного кода через запетую.
     * Пример "255,255,255"
     */
    public static final String PARAMETER_NAME_SELECTION_COLOR = "SelectionColor";
    /**
     * Хранит в себе динамические параметры и может добавлять новые.
     */
    private DynamicParameterMap mapParameter;

    public GPanelCell() {
        this.mapParameter = new DynamicParameterMap();
        createDynamicParameter();
    }

    public GPanel getGPanelObject() {
        return gPanelObject;
    }

    private void createDynamicParameter() {
        mapParameter.putParameterInt(PARAMETER_NAME_SELECTION, 0);
        mapParameter.putParameter(PARAMETER_NAME_SELECTION_COLOR, "0,0,0");
    }

    public void setGPanelObject(GPanel gPanelObject) {
        this.gPanelObject = gPanelObject;
    }

    @Override
    public DynamicParameter getDynamicValues() {
        return mapParameter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        if (gPanelObject != null) {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5, 5, 5, 5);
            c.weightx = 1;
            c.weighty = 1;
            c.fill = GridBagConstraints.BOTH;
            add(gPanelObject, c);
        }
        drawCircleCenter(g);
    }

    /**
     * Рисуем овал в центре клетки если
     * динамический параметр PARAMETER_NAME_SELECTION = 1.
     *
     * @param g Graphics на котором отрицается круг в центре.
     */
    public void drawCircleCenter(Graphics g) {
        //Проверка равно ли значение в PARAMETER_NAME_SELECTION "1".
        if (getDynamicValues().getParameterInt(PARAMETER_NAME_SELECTION) == 0) return;
        //Получение цвета из параметра PARAMETER_NAME_SELECTION.
        g.setColor(getColor(getDynamicValues().getParameter(PARAMETER_NAME_SELECTION_COLOR)));
        g.drawOval((getWidth() / 2) - 5, (getHeight() / 2) - 5, 10, 10);
    }

    /**
     * Получение из строки типа 255,0,0 цвета которому она соответствует в модели RGB.
     * Если из строки не удалось извлечь цвет возвращается черный.
     *
     * @param colorRGB строки типа 255,0,0.
     * @return Цвет которому colorRGB соответствует в модели RGB.
     */
    private Color getColor(String colorRGB) {
        String rgbString[] = colorRGB.split(",");
        Color color;
        try {
            color = new Color(Integer.parseInt(rgbString[0]),
                    Integer.parseInt(rgbString[1]),
                    Integer.parseInt(rgbString[2]));
        } catch (Exception e) {
            return Color.BLACK;
        }
        return color;
    }
}
