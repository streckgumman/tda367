package controller;

import model.GameObject;

import java.awt.event.KeyEvent;

public class PlayerUpdater<Player> extends Updater{


    public PlayerUpdater(GameObject gameObject) {
        super(gameObject);
    }

    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode() ==  KeyEvent.VK_LEFT){
            this.getGameObject().move("left");
            System.out.println("Move left");
        }
        if(event.getKeyCode() ==  KeyEvent.VK_RIGHT){
            this.getGameObject().move("right");
            System.out.println("Move right");
        }
        if(event.getKeyCode() ==  KeyEvent.VK_UP){
            this.getGameObject().move("up");
        }
        if(event.getKeyCode() ==  KeyEvent.VK_DOWN){
            this.getGameObject().move("down");
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
