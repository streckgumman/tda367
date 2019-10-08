package model.levels;

import model.Level;
import model.items.Key;
import model.items.Scissors;
import model.npcs.DogWithGun;
import model.puzzles.Door;

public class Level2 extends Level {

    /**
     * Constructor
     *
     * @param nrInLine
     */
    public Level2(int nrInLine) {
        super(nrInLine);
        addItem(new Scissors("Scissors", 200, 300));
        addItem(new Key(1920 / 2, 1080 / 2));
        addPuzzle(new Door(1920-300,(1080-600)/2,300,600));
    }
}
