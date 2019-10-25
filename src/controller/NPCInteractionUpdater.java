package controller;

import model.*;

import java.awt.event.KeyEvent;

/**
 * Public class that handles interactions with NPC's
 */
public class NPCInteractionUpdater extends Updater<Player> {

    private Game game;

    /**
     * @param player the player from this class's super class
     * @param game   the game
     */
    protected NPCInteractionUpdater(Player player, Game game) {
        super(player);
        this.game = game;
    }

    /**
     * Checks if players and NPC's hitboxes overlap
     * If they overlap, it allows the player to interact with them
     *
     * @param event
     */
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            for (int j = game.getLevel().getNpcs().size() - 1; j >= 0; j--) {
                NPC npc = game.getLevel().getNpcs().get(j);
                if (IntersectionDetector.intersects(getGameObject().getHitbox(), npc.getHitbox())) {
                    npc.interact(npc);
                }
            }
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
