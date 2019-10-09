package model;

import model.levels.Level2;
import model.levels.TestLevel;

import java.util.*;

/**
 * The game instance containing a player and a level.
 */
public class Game {

    private Player player;
    private Level currentLevel;
    private List<Level> levels;

    /**
     * Constructor
     */
    public Game() {
        player = new Player("Duckoo");
        levels = new ArrayList<>();
        levels.add(new TestLevel(0));
        levels.add(new Level2(1));
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

    public void nextLevel() {//@TODO Index out of bounds, implement factory pattern.
        player.resetItem();
        if (levels.get(currentLevel.getNrInLine() + 1) != null) {
            currentLevel = levels.get(currentLevel.getNrInLine() + 1);
        }
    }

    public int getCurrentLevelsNrInLine(){return currentLevel.getNrInLine();}
}
