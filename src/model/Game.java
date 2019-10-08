package model;

import model.levels.TestLevel;

/**
 * The game instance containing a player and a level.
 */
public class Game {

    private Player player;
    private Level currentLevel;

    /**
     * Constructor
     */
    public Game() {
        player = new Player("Duckoo");
        currentLevel = new TestLevel();
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

    public void addObserver(TextObserver observer){
        player.addObserver(observer);
        currentLevel.addObserver(observer);
    }
}
