package model.puzzles;

import model.GameObjectType;
import model.Puzzle;

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
        super(x, y, width, height, GameObjectType.DOOR);
    }

    @Override
    protected void update() {

    }

}
