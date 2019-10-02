package model.items;

import model.Item;
import model.ItemType;

public class Key extends Item {

    public Key(int x, int y) {
        super("Key", ItemType.KEY, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
