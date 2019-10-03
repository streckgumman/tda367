package controller;

import model.IntersectionDetector;
import model.Level;
import model.NPC;
import model.Player;

import java.awt.event.KeyEvent;

public class NPCInteractionUpdater extends Updater<Player> {

    private Level level;

    protected NPCInteractionUpdater(Player player, Level level) {
        super(player);
        this.level = level;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            for (int j = level.getNpcs().size() - 1; j >= 0; j--) {
                NPC npc = level.getNpcs().get(j);
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
