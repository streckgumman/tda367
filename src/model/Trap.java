package model;

/**
 * Abstract class for any trap in the game
 */
public abstract class Trap extends GameObject {

    /**
     * Constructor
     */
    public Trap(int x, int y, int width, int height) {
        super(x, y, width, height);

    }

    public void activate(){
        //fällan ska aktiveras och spelaren ska få en "debuff"
    }

    public void interact(GameObject go){
        activate();
    }

}
