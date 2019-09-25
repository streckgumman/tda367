package view;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JPanel {

    protected final int w, h;

    public View(int w, int h) {
        this.w = w;
        this.h = h;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(w, h));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    abstract void draw(Graphics g);

}
