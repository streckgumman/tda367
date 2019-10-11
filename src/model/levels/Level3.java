package model.levels;

import model.Level;
import model.items.Key;
import model.items.Scissors;
import model.puzzles.Door;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * Level3 represents the level 3 in the game and extends the clss Level
 *
 * */
public class Level3 extends Level {

    /**
     * The public constructor of the class Level3
     *
     * Adds the items "Scissors" and "Key" to the game and the puzzle "Door".
     * @param nrInLine which position in the order of levels the level has
     */
    public Level3(int nrInLine) {
        super(nrInLine);
        addItem(new Key(1920 / 2, 1080 / 2));
        addPuzzle(new Door(1920-300,(1080-600)/2,300,600));
    }
}
