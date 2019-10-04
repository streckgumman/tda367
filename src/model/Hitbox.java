package model;

public class Hitbox {

    private Point point;
    private int width, height;

    public Hitbox(int x, int y, int width, int height) {
        this.point = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    public int getX(){
        return point.getX();
    }

    public int getY(){
        return point.getY();
    }

    public void setX(int x) {
        point.setX(x);
    }

    public void setY(int y) {
        point.setY(y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
