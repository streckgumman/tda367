package model;

/**
 * Represents the player that the user uses to play the game and can control
 */
public class Player extends Charakter {

    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private Item item;

    /**
     * Constructor
     *
     * @param name the player's name
     */
    public Player(String name) {
        super(name, 1920 / 2, 1080 / 2, 804 / 4, 1074 / 4, GameObjectType.PLAYER);
    }

    /**
     * Updates the player every frame
     */
    @Override
    public void update() {
        int dx = 0;
        int dy = 0;
        if (movingRight && getX() < 1920 - 300) {
            dx += 10;
        }
        if (movingLeft && getX() > 0) {
            dx -= 10;
        }
        if (movingUp && getY() > 0) {
            dy -= 10;
        }
        if (movingDown && getY() < 1080 - 250) {
            dy += 10;
        }
        move(dx, dy);
    }

    /**
     * Moves the player in both axis
     *
     * @param dx amount of pixels the player moves along the x-axis
     * @param dy amount of pixels the player moves along the y-axis
     */
    public void move(int dx, int dy) {
        setPosition(getX() + dx, getY() + dy);
    }

    /**
     * Sets whether the player moves right or not
     *
     * @param movingRight whether the player moves right or not
     */
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    /**
     * Sets whether the player moves left or not
     *
     * @param movingLeft whether the player moves left or not
     */
    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    /**
     * Sets whether the player moves up or not
     *
     * @param movingUp whether the player moves up or not
     */
    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    /**
     * Sets whether the player moves down or not
     *
     * @param movingDown whether the player moves down or not
     */
    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    /**
     * The item the player is currently holding
     *
     * @return the item the player is currently holding
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns whether or not the player is moving right
     *
     * @return whether or not the player is moving right
     */
    public boolean isMovingRight() {
        return movingRight;
    }

    public void pickUpItem(Item item) {
        this.item = item;
    }

    public void resetItem() {
        this.item = null;
    }

    /**
     * Returns whether or not the player is moving left
     *
     * @return whether or not the player is moving left
     */
    public boolean isMovingLeft() {
        return movingLeft;
    }

    /**
     * Returns whether or not the player is moving up
     *
     * @return whether or not the player is moving up
     */
    public boolean isMovingUp() {
        return movingUp;
    }

    /**
     * Returns whether or not the player is moving down
     *
     * @return whether or not the player is moving down
     */
    public boolean isMovingDown() {
        return movingDown;
    }

}
