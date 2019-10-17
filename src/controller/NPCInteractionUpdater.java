package controller;

import model.*;

import java.awt.event.KeyEvent;

public class NPCInteractionUpdater extends Updater<Player> {

    private Game game;

    protected NPCInteractionUpdater(Player player, Game game) {
        super(player);
        this.game = game;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            for (int j = game.getLevel().getNpcs().size() - 1; j >= 0; j--) {
                NPC npc = game.getLevel().getNpcs().get(j);
                if (IntersectionDetector.intersects(getGameObject().getHitbox(), npc.getHitbox())) {
                    npc.talk();
                }
            }
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}
