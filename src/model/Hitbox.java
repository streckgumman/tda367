package model;

public class Hitbox {

    private Point point;
    private int width, height;

    public Hitbox(Point point, int width, int height){
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public Point getPosition() {
        return point;
    }

    public int getX(){
        return point.getX();
    }

    public int getY(){
        return point.getY();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
