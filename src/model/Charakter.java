package model;

import java.awt.*;

public abstract class Charakter extends GameObject {

    private String name;

    public Charakter(String name, Point point) {
        super(point);
        this.name = name;
    }
}
