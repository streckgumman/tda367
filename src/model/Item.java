package model;

import java.awt.*;

public abstract class Item extends GameObject {

    private String name;
    private ItemType type;

    public Item(String name, ItemType type) {
        super(new Point(0, 0));
        this.name = name;
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }
}
