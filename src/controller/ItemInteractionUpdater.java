package controller;

import model.IntersectionDetector;
import model.Item;
import model.Level;
import model.Player;

import java.awt.event.KeyEvent;

public class ItemInteractionUpdater extends Updater<Player> {

    private Level level;

    protected ItemInteractionUpdater(Player player, Level level) {
        super(player);
        this.level = level;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            for (int j = level.getItems().size() - 1; j >= 0; j--) {
                Item i = level.getItems().get(j);
                if (IntersectionDetector.intersects(getGameObject().getHitbox(), i.getHitbox())) {
                    if (getGameObject().getItem() != null) {
                        getGameObject().getItem().setPosition(getGameObject().getX(), getGameObject().getY());
                        level.addItem(getGameObject().getItem());
                    }
                    getGameObject().pickUpItem(i);
                    level.getItems().remove(i);
                }
    private void dropItem() {
        if (getGameObject().getItem() != null) {
            getGameObject().getItem().setPosition(getGameObject().getX(), getGameObject().getY());
            level.addItem(getGameObject().getItem());
            getGameObject().pickUpItem(null);
        }
    }
            }
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
