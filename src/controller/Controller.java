package controller;

import model.Level;
import view.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller implements KeyListener {

    private View view;
    private List<Updater> updaters;


    public Controller(View view) {
        this.view = view;
        updaters = new ArrayList<Updater>();
    }

    public void redrawView(){

        view.repaint();
    }

    public void keyPressed(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyPressed(e);
        }
    }

    public void keyReleased(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyReleased(e);
        }
    }

    public void keyTyped(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyTyped(e);
        }
    }

    public void addUpdater(Updater u) {
        updaters.add(u);
    }

}
