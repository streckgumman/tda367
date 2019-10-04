package model.items;

import model.Item;
import model.ItemType;

public class Scissors extends Item {

    public Scissors(String name, int x, int y) {
        super(name, ItemType.SCISSORS, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
