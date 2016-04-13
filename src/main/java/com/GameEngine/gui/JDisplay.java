package com.GameEngine.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nikita on 12.03.2016.
 */
public class JDisplay extends JFrame implements Display {

    public JDisplay() throws HeadlessException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void start() {
        setVisible(true);
    }

    @Override
    public void update() {
        revalidate();
    }

    @Override
    public void showPanel(JPanel jPanel) {
        add(jPanel);
    }

    @Override
    public JFrame getJFrame() {
        return this;
    }
}
