package model;

/**
 * Abstract class for any puzzle in the game
 */
public abstract class Puzzle extends GameObject implements Interactable {

    private boolean solved = false;

    /**
     * Constructor
     */
    public Puzzle(int x, int y, int width, int height) {
        super(new Point(x, y),width, height);
    }


    //PLACEHOLDER
    public void something(){
        //Världen ska vända tillbaka sig rätt och dörren till nästa nivå ska öppnas
    }

    public void interact(GameObject go){
        something();
    }


}
