package model.items;

import model.GameObjectType;
import model.Item;

public class Scissors extends Item {

    public Scissors(String name, int x, int y) {
        super(name, GameObjectType.SCISSORS, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
