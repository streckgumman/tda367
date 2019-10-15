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
    private Puzzle currentPuzzle;
    private boolean levelSolved;
    private int nrPuzzle;

    /**
     * The public constructor for the class Level
     *
     */
    public Level(int nrInLine) {
        npcs = new ArrayList<NPC>();
        puzzles = new ArrayList<Puzzle>();
        traps = new ArrayList<Trap>();
        items = new ArrayList<Item>();
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

    public int getNrInLine() {
        return nrInLine;
    }

    public Puzzle getCurrentPuzzle() {
        return currentPuzzle;
    }

    public void setCurrentPuzzle(Puzzle currentPuzzle) {
        this.currentPuzzle = currentPuzzle;
    }

    protected boolean isLevelSolved() {
        return levelSolved;
    }

    protected void setLevelSolved(boolean levelSolved) {
        this.levelSolved = levelSolved;
    }

    public boolean areAllPuzzlesSolved(){
        for(Puzzle p : puzzles){
            if( !p.isSolved()){
                return false;
            }
        }
        return true;
    }

    protected int getNrPuzzle() {
        return nrPuzzle;
    }

    protected void setNrPuzzle(int nrPuzzle) {
        this.nrPuzzle = nrPuzzle;
    }

    public void startNextPuzzle(){
        puzzles.remove(nrPuzzle);
        nrPuzzle = nrPuzzle + 1;
        currentPuzzle = puzzles.get(nrPuzzle + 1);
        addItem(currentPuzzle.getMyItem());
    }

}

