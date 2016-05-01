package com.GameEngine.gui;

import javax.swing.*;

/**
 * Интерфейс класса который должен отображать JPanel.
 */
public interface Display {
    void start();
    void update();
    void showPanel(JPanel jPanel);
    JFrame getJFrame();
}
