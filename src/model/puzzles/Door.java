package model.puzzles;

import model.GameObjectType;
import model.Point;
import model.Item;
import model.Player;
import model.Puzzle;
import model.Text;
import model.items.Key;

/**
 * @author Amanda Dehlén
 * @author Samuel Widén
 * @author Johannes Kvernes
 * @author Anna Nilsson
 * @author Linnea Johansson
 *
 * Puzzle class for the Door you can open with a key
 */
public class Door extends Puzzle {
    /**
     * The public constructor for the class Door
     *
     * The class Door extends the class Puzzle
     *
     * @param x the position of the Door in x axis
     * @param y the position of the Door in y axis
     * @param width the width of the Door's hitbox
     * @param height the height of the Door's hitbox
     */
    public Door(int x, int y, int width, int height) {
        super(x, y, width, height, GameObjectType.DOOR);
    }

    @Override
    public void update() {

    }

    @Override
    public void promptInteraction() {
        notifyAdd(new Text("Open (E)", Text.TextType.INTERACTION_PROMPT, new Point(getX(), getY())));
        //@TODO if the player doesn't have a key, instead print "The door is locked"
    }

    /**
     * Method checks if the player holds the item in their inventory to solve the puzzle
     * @param player
     * @return true if player holds Key
     */
    @Override
    protected boolean checkIfHoldingItem(Player player) {
        if (player.getItem() != null) {
            if(player.getItem().getType() == GameObjectType.KEY){
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
        return new Key(1920 / 2, 1080 / 2);
    }


}
