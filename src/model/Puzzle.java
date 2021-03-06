package model;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * @author Johannes Kvernes
 * @author Anna Nilsson
 * <p>
 * Abstract class for all puzzles in the game
 */
public abstract class Puzzle extends GameObject {

    private boolean isSolved;

    /**
     * The public constructor for the class Puzzle
     * <p>
     * The class Puzzle extends the class GameObject
     *
     * @param x      the position of the Door in x axis
     * @param y      the position of the Door in y axis
     * @param width  the width of the Door's hitbox
     * @param height the height of the Door's hitbox
     * @param type   the type of GameObject
     */
    public Puzzle(int x, int y, int width, int height, GameObjectType type) {
        super(x, y, width, height, type);
    }


    //PLACEHOLDER
    //This method is going to flip the upside down
    //world back to it's normal state
    public void flipWorld() {
    }

    public void interact(GameObject go) {
        flipWorld();
    }

    /**
     * Method to check if player's hitbox coincides with the puzzle's hitbox.
     * If they coincide, it checks if the player is holding the item to solve the puzzle
     *
     * @param player the character the user controls
     * @return true if the player is holding the correct item
     */
    public boolean checkIfDone(Player player) {
        if (IntersectionDetector.intersects(player.getHitbox(), this.getHitbox())) {
            if (checkIfHoldingItem(player)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void promptInteraction() {
    }

    /**
     * An abstract method implemented by Puzzle's subclasses
     *
     * @param player the character the user controls
     * @return true if player is holding the correct item
     */
    protected abstract boolean checkIfHoldingItem(Player player);

    /**
     * A boolean that returns true if the puzzle is solved
     *
     * @return true if current puzzle is solved
     */
    protected boolean isSolved() {
        return isSolved;
    }

    /**
     * A setter for the isSolved variable
     * It is used to set isSolved to true when a puzzle is solved
     *
     * @param solved
     */
    protected void setSolved(boolean solved) {
        isSolved = solved;
    }

    /**
     * An abstract method implemented by Puzzle's subclasses
     * A getter for an item that appears when you solve a puzzle
     *
     * @return the item you need for the next puzzle
     */
    abstract protected Item getMyItem();
}
