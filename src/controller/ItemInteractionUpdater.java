package controller;

import model.*;

import java.awt.event.KeyEvent;

/**
 * @author Johannes Kvernes
 * @author Anna Nilsson
 * <p>
 * Updater for all interactions with items
 */
public class ItemInteractionUpdater extends Updater<Player> {

    private Game game;


    /**
     * Constructor
     *
     * @param player the players that interacts with items
     * @param game   the game that the items reside in
     */
    protected ItemInteractionUpdater(Player player, Game game) {
        super(player);
        this.game = game;
    }

    /**
     * Depending on the key event calls method
     * itemDetector or dropItem
     *
     * @param event
     */
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            itemDetector();
        } else if (event.getKeyCode() == KeyEvent.VK_Q) {
            dropItem();
        }
    }

    /**
     * Method that drops the players item into the world
     * if the player is holding one
     */
    private void dropItem() {
        if (getGameObject().getItem() != null) {
            getGameObject().getItem().setPosition(getGameObject().getX(), getGameObject().getY());
            game.getLevel().addItem(getGameObject().getItem());
            getGameObject().pickUpItem(null);
        }
    }

    /**
     * Method that checks if an item is intersected
     */
    private void itemDetector() {
        for (int j = game.getLevel().getItems().size() - 1; j >= 0; j--) {
            Item i = game.getLevel().getItems().get(j);
            if (IntersectionDetector.intersects(getGameObject().getHitbox(), i.getHitbox())) {
                pickUpItem(i);
                break;
            }
        }
    }

    /**
     * Method that handles the player picking up an item
     *
     * @param i
     */
    private void pickUpItem(Item i) {
        dropItem();
        getGameObject().pickUpItem(i);
        game.getLevel().getItems().remove(i);
        i.stopShowingInteractionPrompt();
        i.setInteractionPrompted(false);
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
