package model;
/**
    Player represents the character that the user are able to controll

    @author Amanda
    @since 2019-09-28
 */
public class Point {

    /** The coordinates in x and y axis */
    private int x;
    private int y;

    /**
     * The constructor that takes in the coordinates in x and y axis and sets the x and y coordinates to it
     *
     * @param x coordinate ín x axis
     * @param y coordinate in y axis
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * The constructor that takes in an point and sets the point to the parameters x and y coordinates
     *
     * @param point an instance of Point
     */
    public Point(Point point){
        x = point.getX();
        y = point.getY();
    }

    /**
     * @return the x coordinate of the position
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate of the position
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x coordinate to the parameter
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate to the parameter
     */
    public void setY(int y) {
        this.y = y;
    }
}

