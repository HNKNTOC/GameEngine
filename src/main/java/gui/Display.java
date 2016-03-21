package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Created by Nikita on 12.03.2016.
 */
public interface Display {
    void start();
    void update();
    void showPanel(JPanel jPanel);
    void setListImage(HashMap<Integer,Image> listImage);
    void addKeyListener(KeyListener keyListener);
}
