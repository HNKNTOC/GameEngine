package com.GameEngine.gui;

import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * Created by Nikita on 12.03.2016.
 */
public interface Display {
    void start();
    void update();
    void showPanel(JPanel jPanel);
    void addKeyListener(KeyListener keyListener);
}
