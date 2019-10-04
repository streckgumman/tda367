package model;

/**
 * Abstract class for any puzzle in the game
 */
public abstract class Puzzle extends GameObject implements Interactable {

    private boolean solved = false;
    private PuzzleType puzzleType;

    /**
     * Constructor
     */
    public Puzzle(int x, int y, int width, int height, PuzzleType puzzleType)
    {
        super(new Point(x, y),width, height);
        this.puzzleType = puzzleType;
    }


    //PLACEHOLDER
    public void something(){
        //Världen ska vända tillbaka sig rätt och dörren till nästa nivå ska öppnas
    }

    public void interact(GameObject go){
        something();
    }


    public boolean isSolved() {
        return solved;
    }

    protected void setSolved(boolean solved) {
        this.solved = solved;
    }


    public PuzzleType getPuzzleType() {
        return puzzleType;
    }
}
