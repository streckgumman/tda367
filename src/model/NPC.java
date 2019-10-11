package model;

public abstract class NPC extends Charakter {

    /**
     * Constructor
     *
     * @param name the NPC's name
     * @param type the type of game Object it is
     */
    public NPC(String name, GameObjectType type, int x, int y, int width, int height) {
        super(name, x, y, width, height, type);
    }

    public abstract void talk();

    public void interact(GameObject go) {
        talk();
    }

}
