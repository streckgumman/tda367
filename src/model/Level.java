package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for the level to play
 */
public abstract class Level {

    private Player player;
    private List<NPC> npcs;
    private List<Puzzle> puzzles;
    private List<Trap> traps;
    private List<Item> items;

    /**
     * Constructor
     */
    public Level() {
        npcs = new ArrayList<NPC>();
        puzzles = new ArrayList<Puzzle>();
        traps = new ArrayList<Trap>();
        items = new ArrayList<Item>();
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

    public void addNPC(NPC npc){
        npcs.add(npc);
    }

    public List<NPC> getNpcs(){
        return npcs;
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void addPuzzle(Puzzle p){
        puzzles.add(p);
    }
}
