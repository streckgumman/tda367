package model;

public class Point {

    int x;
    int y;

    public Point(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        x = point.getX();
        y = point.getY();
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

}

