package model;

/**
 * GameObject represent a object that can exist in the game
 *
 * @author Amanda Dehlén
 * @author Samuel Widén
 * @author Linnea Johansson
 * @author Johannes Kvernes
 *
 * @since 2019-10-01
 */
public abstract class GameObject implements HitboxOwner {

    protected GameObjectType type;
    private Hitbox hitbox;

    /**
     * The public constructor for the class GameObject
     * @param x the position of the GameObject in x axis
     * @param y the position of the GameObject in y axis
     * @param width the width of the GameObject's hitbox
     * @param height the height of the GameObject's hitbox
     */
    public GameObject(int x, int y, int width, int height) {
        this.hitbox = new Hitbox(x, y, width, height);
    }

    /**
     * Sets the position of the GameObject to the x and y coordinates
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setPosition(int x, int y) {
        setXPosition(x);
        setYPosition(y);
    }

    /**
     * Sets the position of the GameObject to the x coordinate and the original y coordinate
     *
     * @param x the x coordinate
     */
    public void setXPosition(int x) {
        hitbox.setX(x);
    }

    /**
     * Sets the position of the GameObject to the y coordinate and the original x coordinate
     * @param y the y coordinate
     */
    public void setYPosition(int y) {
        hitbox.setY(y);
    }

    public int getX() {
        return hitbox.getX();
    }

    public int getY() {
        return hitbox.getY();
    }

    public int getWidth() {
        return hitbox.getWidth();
    }

    public int getHeight() {
        return hitbox.getHeight();
    }

    /**
     * The abstract protected method that are implemented in subclasses
     */
    protected abstract void update();

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public GameObjectType getType() {
        return type;
    }
}
