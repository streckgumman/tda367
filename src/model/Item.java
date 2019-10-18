package model;

/**
 * @author Johannes Kvernes
 * @author Samuel Widen
 *
 * Abstract class for any item in the game.
 */
public abstract class Item extends GameObject {
    private String name;

    /**
     * Constructor
     *
     * @param name the name of the item
     * @param type which type of item it is
     */
    public Item(String name, GameObjectType type, int x, int y, int width, int height) {
        super(x, y, width, height, type);
        this.name = name;
    }

    /**
     * The abstract public method that are implemented in subclasses
     */
    // Is not fully implemented in subclasses
    //Should be moved to it's own class or interface
    public abstract void use();


    public void interact(GameObject go) {

    }

}
