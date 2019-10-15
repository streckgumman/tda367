package model;

/**
 * Abstract class for any puzzle in the game
 */
public abstract class Puzzle extends GameObject {

    private boolean isSolved;

    /**
     * Constructor
     */
    public Puzzle(int x, int y, int width, int height, GameObjectType type) {
        super(x, y, width, height, type);
    }


    //PLACEHOLDER
    public void something() {
        //Världen ska vända tillbaka sig rätt och dörren till nästa nivå ska öppnas
    }

    public void interact(GameObject go) {
        something();
    }


    public boolean checkIfDone(Player player){
        if (IntersectionDetector.intersects(player.getHitbox(), this.getHitbox())) {
            if (checkIfHoldingItem(player)) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean checkIfHoldingItem(Player player);

    protected boolean isSolved() {
        return isSolved;
    }

    protected void setSolved(boolean solved) {
        isSolved = solved;
    }
}
