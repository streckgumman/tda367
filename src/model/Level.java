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

    //private Player player;
    private List<NPC> npcs;
    private List<Puzzle> puzzles;
    private List<Trap> traps;
    private List<Item> items;
    private int nrInLine;
    private Puzzle currentPuzzle;
    private boolean levelSolved;
    private int nrPuzzle;
    private List<TextObserver> observers;

    /**
     * The public constructor for the class Level
     *
     */
    public Level(int nrInLine) {
        //this.player = player;
        npcs = new ArrayList<>();
        puzzles = new ArrayList<>();
        traps = new ArrayList<>();
        items = new ArrayList<>();
        observers = new ArrayList<>();
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
        for (GameObject gameObject : getGameObjects()) {
            gameObject.addObserver(observer);
        }
        this.observers.add(observer);
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(npcs);
        gameObjects.addAll(puzzles);
        gameObjects.addAll(traps);
        gameObjects.addAll(items);

        return gameObjects;
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

        puzzles.remove(0);
        currentPuzzle = puzzles.get(0);
        Item newItem = currentPuzzle.getMyItem();
        addItem(newItem);
        for (TextObserver observer : observers){
            newItem.addObserver(observer);
        }

    }

}

