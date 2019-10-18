package controller;

import model.*;

import java.awt.event.KeyEvent;

public class ItemInteractionUpdater extends Updater<Player> {

    private Game game;

    protected ItemInteractionUpdater(Player player, Game game) {
        super(player);
        this.game = game;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            itemDetector();
        } else if (event.getKeyCode() == KeyEvent.VK_Q) {
            dropItem();
        }
    }

    private void dropItem() {
        if (getGameObject().getItem() != null) {
            getGameObject().getItem().setPosition(getGameObject().getX(), getGameObject().getY());
            game.getLevel().addItem(getGameObject().getItem());
            getGameObject().pickUpItem(null);
        }
    }

    private void itemDetector() {
        for (int j = game.getLevel().getItems().size() - 1; j >= 0; j--) {
            Item i = game.getLevel().getItems().get(j);
            if (IntersectionDetector.intersects(getGameObject().getHitbox(), i.getHitbox())) {
                pickUpItem(i);
                break;
            }
        }
    }

    private void pickUpItem(Item i) {
        dropItem();
        getGameObject().pickUpItem(i);
        game.getLevel().getItems().remove(i);
        i.stopShowingInteractionPrompt();
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
