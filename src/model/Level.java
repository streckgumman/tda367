package model;

public abstract class Level {

    private Player player;
    private NPC[] npcs;
    private Puzzle[] puzzles;
    private Trap[] traps;
    private Item[] items;

    public Level() {

    }

    public Player getPlayer() {
        return player;
    }

    public NPC[] getPlayers() {
        return npcs;
    }

    public Puzzle[] getPuzzles() {
        return puzzles;
    }

    public Trap[] getTraps() {
        return traps;
    }

    public Item[] getItems() {
        return items;
    }


}
