package controller;

import model.Player;
import java.awt.event.KeyEvent;

public class PlayerUpdater extends Updater<Player> {


    public PlayerUpdater(Player player) {
        super(player);
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
            getGameObject().setMovingDown(true);
        }
    }

    public void keyReleased(KeyEvent event) {
        if(event.getKeyCode() ==  KeyEvent.VK_LEFT){
            getGameObject().setMovingLeft(false);
        }
        if(event.getKeyCode() ==  KeyEvent.VK_RIGHT){
            getGameObject().setMovingRight(false);
        }
        if(event.getKeyCode() ==  KeyEvent.VK_UP){
            getGameObject().setMovingUp(false);
        }
        if(event.getKeyCode() ==  KeyEvent.VK_DOWN){
            getGameObject().setMovingDown(false);
        }
    }

    public void keyTyped(KeyEvent event) {

    }
}
