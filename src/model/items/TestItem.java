package model.items;

import model.Item;
import model.ItemType;

public class TestItem extends Item {

    public TestItem(String name) {
        super(name, ItemType.SCISSORS);
    }

    protected void update() {

    }
}
