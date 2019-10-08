package model.puzzles;

import model.Puzzle;
import model.PuzzleType;

public class Door extends Puzzle {
    /**
     * Constructor
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Door(int x, int y, int width, int height) {
        super(x, y, width, height, PuzzleType.DOOR);
    }

    @Override
    protected void update() {

    }

}
