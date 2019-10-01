package model;

/**
 * Abstract class for any trap in the game
 */
public abstract class Trap extends GameObject implements Interactable{

    /**
     * Constructor
     */
    public Trap(int width, int height) {
        super(new Point(0, 0), width, height);

    }

    public void activate(){
        //fällan ska aktiveras och spelaren ska få en "debuff"
    }

    public void interact(GameObject go){
        activate();
    }

}
