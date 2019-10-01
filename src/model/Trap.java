package model;

/**
 * Abstract class for any trap in the game
 */
public abstract class Trap extends GameObject implements Interactable{

    /**
     * Constructor
     */
    public Trap() {
        super(new Point(0, 0));

    }

    public void activate(){
        //fällan ska aktiveras och spelaren ska få en "debuff"
    }

    public void interact(GameObject go){
        activate();
    }

}
