package model.items;

import model.GameObjectType;
import model.Item;

/**
 * @author Linnea Johansson
 * @author Amanda Dehlén
 * <p>
 * The class Hammer represent the item hammer that can be used to solve the puzzle Rock
 */
public class Hammer extends Item {

    /**
     * The public constructor for the class Hammer
     * <p>
     * The class Hammer extends the class Item
     *
     * @param x the position of the Key in x axis
     * @param y the position of the Key in y axis
     */
    public Hammer(int x, int y) {
        super("Hammer", GameObjectType.HAMMER, x, y, 80, 80);
    }

    public void use() {

    }

    protected void update() {

    }
}
