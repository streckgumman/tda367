package model;

import java.awt.*;

public class GameObject {

    private Point point;

    public GameObject(Point point){
        this.point = point;
    }

    private void setPosition(int x, int y){
        point = new Point(x, y);
    }

    private void setXPosition(int x){
        int y = (int)point.getY();
        point = new Point(x, y);
    }

    private void setYPosition(int y){
        int x = (int)point.getX();
        point = new Point(x, y);
    }

    private Point getPosition(){
        return new Point(point);
    }

    private void move(){}

}
