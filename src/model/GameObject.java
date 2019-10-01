package model;

import java.awt.*;

/**
 * GameObject represent a object that can exist in the game
 *
 * @author Amanda Dehlén, Linnea Johansson, Anna Nilsson
 * @since 2019-10-01
 *
 */
public abstract class GameObject implements HitboxOwner{

    private Hitbox hitbox;

    public GameObject(Point point, int width, int height) {
        this.hitbox = new Hitbox(point, width, height);
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
        getHitbox().getPosition().setX(x);
    }

    /**
     * Sets the position of the GameObject to the y coordinate and the original x coordinate
     *
     * @param y the y coordinate
     */
    public void setYPosition(int y) {
        getHitbox().getPosition().setY(y);
    }

    /**
     * @return a copy of the position that GameObject holds
     */
    public Point getPosition() {
        return new Point(getHitbox().getPosition());
    }

    public int getX() {
        return (int) getPosition().getX();
    }

    public int getY() {
        return (int) getPosition().getY();
    }

    protected abstract void update();

    public Hitbox getHitbox() {
        return this.hitbox;
    }
}
