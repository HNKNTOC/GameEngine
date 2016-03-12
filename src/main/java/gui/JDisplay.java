package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by Nikita on 12.03.2016.
 */
public class JDisplay extends JFrame implements Display {

    public JDisplay() throws HeadlessException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
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
    public void setListImage(HashMap<Integer, Image> listImage) {

    }
}
