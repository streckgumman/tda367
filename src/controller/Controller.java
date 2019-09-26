package controller;

import model.Game;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller implements KeyListener {

    Game game;
    private View view;
    private List<Updater> updaters;


    public Controller(View view, Game game){
        this.view = view;
        this.game = game;
        updaters = new ArrayList<Updater>();
    }

    protected abstract void updateModel();

    protected void redrawView() {
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

    /**
     * Updates and displays the model once (one frame)
     */
    public void update() {
        updateModel();
        redrawView();
    }

}
