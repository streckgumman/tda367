package model;

import java.awt.*;

public abstract class Item extends GameObject {

    private String name;

    public Item(String name) {
        super(new Point(0, 0));
        this.name = name;
    }
}
