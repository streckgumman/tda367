package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JPanel {

    protected final int w, h;
    protected final Game game;

    public View(int w, int h, Game game) {
        this.w = w;
        this.h = h;
        this.game = game;
        setFocusable(true);
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
