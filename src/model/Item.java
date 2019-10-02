package model;

/**
 * Abstract class for any item in the game.
 */
public abstract class Item extends GameObject implements Interactable{
    private String name;
    private ItemType type;

    /**
     * Constructor
     *
     * @param name the name of the item
     * @param type which type of item it is
     */
    public Item(String name, ItemType type, int width, int height) {
        super(new Point(0, 0), 80, 80);
        this.name = name;
        this.type = type;
    }

    /**
     * The type of item that this is item is
     *
     * @return the item's type
     */
    public ItemType getType() {
        return type;
    }

    public abstract void use();



    public void interact(GameObject go){

    }

}
