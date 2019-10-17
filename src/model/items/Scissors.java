package model.items;

import model.GameObjectType;
import model.Item;

/**
 * @author Johannes Kvernes
 *
 * The class Scissors represent the item Scissor that can be used to solve the puzzle Bush
 */
public class Scissors extends Item {

    /**
     * The public constructor for the class Scissors
     *
     * The class Scissors extends the class Item
     *
     * @param name The name of the Scissor
     * @param x the position of the Bush in x axis
     * @param y the position of the Bush in y axis
     */
    public Scissors(String name, int x, int y) {
        super(name, GameObjectType.SCISSORS, x, y, 80, 80);
    }

    protected void update() {

    }

    public void use() {

    }
}
