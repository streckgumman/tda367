package model;

/**
 * Abstract class for any NPC (non-player character) in the game.
 * An NPC is a character
 */
public abstract class NPC extends Charakter implements Interactable{

    /**
     * Constructor
     * @param name The NPC's name
     */
    public NPC(String name) {
        super(name, new Point(0, 0));
    }

    public void talk(){
        //npc'n ska starta en dialog med spelaren
    }

    public void interact(GameObject go){
        talk();
    }


}
