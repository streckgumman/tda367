package model;

import model.levels.Level2;
import model.levels.Level3;
import model.levels.Level1;

import java.util.*;

/**
 * @author Amanda Dehlén
 * @author Samuel Widén
 * @author Linnea Johansson
 * @author Johannes Kvernes
 * @author Anna Nilson
 * <p>
 * The game instance containing a player and a level.
 */
public class Game {

    private Player player;
    private Level currentLevel;
    private List<Level> levels;

    /**
     * The public constructor for the class Game
     */
    public Game() {
        player = new Player("Duckoo");
        levels = new ArrayList<>();
        levels.add(new Level1(0, player));
        levels.add(new Level2(1, player));
        levels.add(new Level3(2, player));
        currentLevel = levels.get(0);
    }

    /**
     * The game's player
     *
     * @return the game's player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * The level which is currently being played
     *
     * @return the current level
     */
    public Level getLevel() {
        return currentLevel;
    }

    /**
     * Adds an observer to all GameObjects in the current level.
     *
     * @param observer The observer that shall be added.
     */
    public void addObserver(TextObserver observer) {
        player.addObserver(observer);
        currentLevel.addObserver(observer);
    }

    /**
     * Changes the level to the next one in the list of levels and resets the player's item so it holds no item
     */
    public void nextLevel() {//@TODO Index out of bounds, implement factory pattern.
        player.resetItem();
        if (levels.get(currentLevel.getNrInLine() + 1) != null) {
            currentLevel = levels.get(currentLevel.getNrInLine() + 1);
        }
    }

    /**
     * @return which place in the list items that the current level is located at
     */

    public int getCurrentLevelsNrInLine() {
        return currentLevel.getNrInLine();
    }

    public void updateModel() {


        for (GameObject g : getLevel().getGameObjects()) {
            g.update();
            if (IntersectionDetector.intersects(g.getHitbox(), getPlayer().getHitbox())) {
                g.promptInteraction();
            }
        }

        for (NPC npc : getLevel().getNpcs()) {
            if (!IntersectionDetector.intersects(npc.getHitbox(), getPlayer().getHitbox())) {
                npc.stopTalking();
            }
        }
    }
}
