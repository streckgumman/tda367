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
    public Item(String name, ItemType type) {
        super(new Point(0, 0));
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

    public void pickup(Player player){
        //ska lägga till objektet i spelarens ryggsäck
        player.pickUpItem(this);
    }

    public void drop(){

        //ska släppa objektet på "marken", ge tillbaka det till level
        //behöver ha tillgång till leveln
    }

    public abstract void use();



    public void interact(GameObject go){
        // bad code, will be changed
        if (go instanceof Player) {
            pickup((Player) go);
        }
    }

}
