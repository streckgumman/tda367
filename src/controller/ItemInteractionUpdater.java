package controller;

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
        double interactionDistance = 50;
        if (event.getKeyCode() == KeyEvent.VK_E) {
            for (Item i : level.getItems()) {
                if (distance(getGameObject().getX(), getGameObject().getY(), i.getX(), i.getY()) < interactionDistance) {
                    if (getGameObject().getItem() != null) {
                        getGameObject().pickUpItem(i);
                    }
                }
            }
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
