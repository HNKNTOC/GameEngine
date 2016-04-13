package com.GameEngine.gui;

import javax.swing.*;

/**
 * Created by Nikita on 12.03.2016.
 */
public interface Display {
    void start();
    void update();
    void showPanel(JPanel jPanel);

    JFrame getJFrame();
}
