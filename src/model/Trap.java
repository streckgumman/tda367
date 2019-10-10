package model;

/**
 * Abstract class for any trap in the game
 */
public abstract class Trap extends GameObject {

    /**
     * Constructor
     */
    public Trap(int x, int y, int width, int height, GameObjectType type) {
        super(x, y, width, height, type);

    }

    public void activate(){
        //fällan ska aktiveras och spelaren ska få en "debuff"
    }

    public void interact(GameObject go){
        activate();
    }

}
