package controller;

import model.GameObject;

import java.awt.event.KeyEvent;

/**
 * Abstract class that handles key input
 *
 * @param <T>
 */
public abstract class Updater<T extends GameObject> {

    private T gameObject;

    protected Updater(T gameObject) {
        this.gameObject = gameObject;
    }

    /**
     * Handles key input
     *
     * @param event
     */
    public abstract void keyPressed(KeyEvent event);

    /**
     * Handles key input
     *
     * @param event
     */
    public abstract void keyReleased(KeyEvent event);

    /**
     * Handles key input
     *
     * @param event
     */
    public abstract void keyTyped(KeyEvent event);

    protected T getGameObject() {
        return gameObject;
    }
}
