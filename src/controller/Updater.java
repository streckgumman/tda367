package controller;

import model.GameObject;

import java.awt.event.KeyEvent;

public abstract class Updater<T extends GameObject> {

    T gameObject;

    public Updater(T gameObject){
        this.gameObject = gameObject;
    }

//    public abstract void update(KeyEvent event);

    public abstract void keyPressed(KeyEvent event);
    public abstract void keyReleased(KeyEvent event);
    public abstract void keyTyped(KeyEvent event);

    public T getGameObject() {
        return gameObject;
    }
}
