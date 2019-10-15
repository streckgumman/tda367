package model.puzzles;

import model.GameObjectType;
import model.Item;
import model.Player;
import model.Puzzle;
import model.items.Scissors;

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
            if (player.getItem().getType() == GameObjectType.SCISSORS){
                setSolved(true);
                System.out.println("Bush is solved");
                return true;
            }
        }
        return false;
    }

    protected Item getMyItem() {
        return new Scissors("Scissors", 200, 300);
    }
}
