package model.items;

import model.Item;
import model.ItemType;

public class TestItem extends Item {

    public TestItem(String name, int x, int y) {
        super(name, ItemType.SCISSORS, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
