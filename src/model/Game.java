package model;

import model.levels.TestLevel;

public class Game {

    Player player;
    Level currentLevel;

    public Game() {
        player = new Player("Duckoo");
        currentLevel = new TestLevel();
    }

    public Player getPlayer() {
        return player;
    }

    public Level getLevel() {
        return currentLevel;
    }
}
