package model;

import java.awt.*;

public abstract class GameObject {

    private Point point;

    public GameObject(Point point){
        this.point = point;
    }

    protected void setPosition(int x, int y){
        point = new Point(x, y);
    }

    protected void setXPosition(int x){
        int y = (int)point.getY();
        point = new Point(x, y);
    }

    protected void setYPosition(int y){
        int x = (int)point.getX();
        point = new Point(x, y);
    }

    public Point getPosition(){
        return new Point(point);
    }

//    public abstract void move(String string);

    public int getX() {
        return (int) getPosition().getX();
    }

    public int getY() {
        return (int) getPosition().getY();
    }

    protected abstract void update();

}
