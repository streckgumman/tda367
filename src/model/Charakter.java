package model;

import java.awt.*;

public abstract class Charakter extends GameObject{

    private String name;

    public Charakter(String name) {
        super(new Point(0,0));
        this.name = name;
    }


}
