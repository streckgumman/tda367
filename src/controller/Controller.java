package controller;

import model.Game;
import view.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Kvernes
 * @author Samuel Widen
 * @author Anna Nilsson
 * @author Linnea Johanson
 * @author Amanda Dahlen
 *
 * Abstract class for all controllers
 */
public abstract class Controller implements KeyListener {

    Game game;
    private View view;
    private List<Updater> updaters;

    /**
     * Constructor
     *
     * @param view the View that controller holds
     * @param game the Game that controller holds
     */
    public Controller(View view, Game game) {
        this.view = view;
        this.game = game;
        updaters = new ArrayList<Updater>();
    }

    /**
     * The protected abstract method that will be
     * implemented in subclasses
     */
    protected abstract void updateModel();

    protected void redrawView() {
        view.repaint();
    }

    /**
     * Sends its key event to its updater
     */
    public void keyPressed(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyPressed(e);
        }
    }

    /**
     * Sends its key event to its updater
     */
    public void keyReleased(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyReleased(e);
        }
    }

    /**
     * Sends its key event to its updater
     */
    public void keyTyped(KeyEvent e) {
        for (Updater updater : updaters) {
            updater.keyTyped(e);
        }
    }
    /**
     * Adds a updater to the controller
     */
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

    /**
     * Returns the view to the controller
     *
     * @return the view to the controller
     */
    public View getView() {
        return view;
    }

}
