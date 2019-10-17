package model.items;

import model.GameObjectType;
import model.Item;

/**
 * @author Johannes Kvernes
 *
 * The class Scissors represent the item Scissor that can be used to solve the puzzle Bush
 */
public class Key extends Item {

    /**
     * The public constructor for the class Key
     *
     * The class Key extends the class Item
     * @param x the position of the Key in x axis
     * @param y the position of the Key in y axis
     */
    public Key(int x, int y) {
        super("Key", GameObjectType.KEY, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
