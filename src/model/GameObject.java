package model;

import java.awt.*;

/**
 * GameObject represent a object that can exist in the game
 *
 * @author Amanda Dehlén, Linnea Johansson
 * @since 2019-09-26
 */
public abstract class GameObject {

    /**
     * The position of the GameObject in the game
     */
    private Point point;

    public GameObject(Point point) {
        this.point = point;
    }

    /**
     * Sets the position of the GameObject to the x and y coordinates
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setPosition(int x, int y) {
        point = new Point(x, y);
    }

    /**
     * Sets the position of the GameObject to the x coordinate and the original y coordinate
     *
     * @param x the x coordinate
     */
    public void setXPosition(int x) {
        int y = (int) point.getY();
        point = new Point(x, y);
    }

    /**
     * Sets the position of the GameObject to the y coordinate and the original x coordinate
     *
     * @param y the y coordinate
     */
    public void setYPosition(int y) {
        int x = (int) point.getX();
        point = new Point(x, y);
    }

    /**
     * @return a copy of the Point that GameObject holds
     */
    public Point getPosition() {
        return new Point(point);
    }

    public int getX() {
        return (int) getPosition().getX();
    }

    public int getY() {
        return (int) getPosition().getY();
    }

    protected abstract void update();
}
