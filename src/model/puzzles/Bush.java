package model.puzzles;

import model.GameObjectType;
import model.Item;
import model.Player;
import model.Puzzle;
import model.items.Scissors;


/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * Puzzle class for the Bush you can cut with scissors
 */
public class Bush extends Puzzle {

    /**
     * The public constructor for the class Bush
     *
     * The class Bush extends the class Puzzle
     *
     * @param x the position of the Bush in x axis
     * @param y the position of the Bush in y axis
     * @param width the width of the Bush's hitbox
     * @param height the height of the Bush's hitbox
     */
    public Bush(int x, int y, int width, int height) {
        super(x, y, width, height, GameObjectType.BUSH);
    }


    protected void update() {

    }

    /**
     * Method checks if the player holds the item in their inventory to solve the puzzle
     * @param player
     * @return true if player holds scissor
     */
    @Override
    protected boolean checkIfHoldingItem(Player player) {
        if (player.getItem() != null) {
            if (player.getItem().getType() == GameObjectType.SCISSORS){
                setSolved(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns an item that appears when you finish the puzzle
     *
     * @return Scissors
     */
    protected Item getMyItem() {
        return new Scissors("Scissors", 200, 300);
    }
}
