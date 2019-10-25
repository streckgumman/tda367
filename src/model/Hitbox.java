package model;

public class Hitbox {

    private Point point;
    private int width, height;

    public Hitbox(int x, int y, int width, int height) {
        this.point = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * @return the objects x position
     */
    public int getX() {
        return point.getX();
    }

    /**
     * @return the objects y position
     */
    public int getY() {
        return point.getY();
    }

    /**
     * Sets the x position
     */
    public void setX(int x) {
        point.setX(x);
    }

    /**
     * Sets the y position
     */
    public void setY(int y) {
        point.setY(y);
    }

    /**
     * @return the objects width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the objects height
     */
    public int getHeight() {
        return height;
    }
}
