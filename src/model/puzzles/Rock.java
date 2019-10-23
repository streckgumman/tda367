package model.puzzles;

import model.GameObjectType;
import model.Item;
import model.Player;
import model.Puzzle;
import model.items.Key;
import model.items.Scissors;

public class Rock extends Puzzle {
    /**
     * The public constructor for the class Puzzle
     * <p>
     * The class Puzzle extends the class GameObject
     *
     * @param x      the position of the Door in x axis
     * @param y      the position of the Door in y axis
     * @param width  the width of the Door's hitbox
     * @param height the height of the Door's hitbox
     */
    public Rock(int x, int y, int width, int height) {
        super(x, y, width, height, GameObjectType.ROCK);
    }

    /**
     * Method checks if the player holds the item in their inventory to solve the puzzle
     *
     * @param player
     * @return true if player holds hammer
     */
    @Override
    protected boolean checkIfHoldingItem(Player player) {
        if (player.getItem() != null) {
            if (player.getItem().getType() == GameObjectType.HAMMER) {
                setSolved(true);

                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns an item that appears when you finish the puzzle
     *
     * @return key
     */
    protected Item getMyItem() {
        return new Scissors("Scissors", 1000 - 300, 1080 - 300);
    }


    protected void update() {

    }
}
