package controller;

import model.Player;

import java.awt.event.KeyEvent;

/**
 *Public class that updates the players movement
 */
public class PlayerMovementUpdater extends Updater<Player> {

    /**
     * @param player the player
     */
    public PlayerMovementUpdater(Player player) {
        super(player);
    }

    /**
     * Takes a keyEvent and sets corresponding movement direction to true.
     * @param event
     */
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            getGameObject().setMovingLeft(true);
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            getGameObject().setMovingRight(true);
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            getGameObject().setMovingUp(true);
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            getGameObject().setMovingDown(true);
        }
    }

    /**
     * Takes a keyEvent and sets corresponding movement direction to false.
     * @param event
     */
    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            getGameObject().setMovingLeft(false);
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            getGameObject().setMovingRight(false);
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            getGameObject().setMovingUp(false);
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            getGameObject().setMovingDown(false);
        }
    }

    public void keyTyped(KeyEvent event) {

    }
}
