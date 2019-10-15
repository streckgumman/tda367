package model.puzzles;

import model.GameObjectType;
import model.Player;
import model.Puzzle;

public class Bush extends Puzzle {

    /**
     * Constructor
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Bush(int x, int y, int width, int height) {
        super(x, y, width, height, GameObjectType.BUSH);
    }

    protected void update() {

    }

    @Override
    protected boolean checkIfHoldingItem(Player player) {
        if (player.getItem() != null) {
            return (player.getItem().getType() == GameObjectType.SCISSORS);
        }
        return false;
    }
}
