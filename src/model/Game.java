package model;

public class Game {

    Player player;
    Level currentLevel;

    public Game() {
        player = new Player("Duckoo");
    }

    public Player getPlayer() {
        return player;
    }
}
