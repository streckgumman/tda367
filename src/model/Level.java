package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amanda Dehlén
 * @author Samuel Widén
 * @author Linnea Johansson
 * @author Johannes Kvernes
 * @author Anna Nilson
 *
 * Class for the level to play
 */
public abstract class Level {

    private Player player;
    private List<NPC> npcs;
    private List<Puzzle> puzzles;
    private List<Trap> traps;
    private List<Item> items;
    private int nrInLine;

    /**
     * The public constructor for the class Level
     *
     */
    public Level(int nrInLine, Player player) {
        this.player = player;
        npcs = new ArrayList<>();
        puzzles = new ArrayList<>();
        traps = new ArrayList<>();
        items = new ArrayList<>();
        this.nrInLine = nrInLine;
    }

    /**
     * The list of items in the level
     *
     * @return the level's items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Adds an item to the level
     *
     * @param i the item to be added
     */
    public void addItem(Item i) {
        items.add(i);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void addPuzzle(Puzzle p) {
        puzzles.add(p);
    }

    public void addObserver(TextObserver observer) {
        List<GameObject> gameObjects = getGameObjects();
        for (GameObject gameObject : gameObjects) {
            gameObject.addObserver(observer);
        }
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        if (player != null) {
            gameObjects.add(player);
        }
        gameObjects.addAll(npcs);
        gameObjects.addAll(puzzles);
        gameObjects.addAll(traps);
        gameObjects.addAll(items);

        return gameObjects;
    }

    public int getNrInLine() {
        return nrInLine;
    }
}

