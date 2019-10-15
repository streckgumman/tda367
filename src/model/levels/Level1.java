package model.levels;

import model.Level;
import model.items.Key;
import model.items.Scissors;
import model.npcs.DogWithGun;
import model.puzzles.Bush;
import model.puzzles.Door;

/**
 * @author Johannes Kvernes
 *
 * Level3 represents the level 3 in the game and extends the clss Level
 *
 */
public class Level1 extends Level {
    /**
     * The public constructor of the class Level3
     *
     * Adds the items "Scissors" and "Key", the puzzle "Door" and the NPC "Dog with gun" to the game
     * @param nrInLine which position in the order of levels the level has
     */
    public Level1(int nrInLine) {
        super(nrInLine);
        addItem(new Scissors("Scissors", 200, 300));
        addItem(new Key(1920 / 2, 1080 / 2));
        addNPC(new DogWithGun("Dog with gun"));
        addPuzzle(new Bush(1000-300,1080-300,300,200));
        addPuzzle(new Door(1920-300,(1080-600)/2,300,600));
        super.setCurrentPuzzle(getPuzzles().get(0));
    }
}
