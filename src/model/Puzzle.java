package model;

/**
 * Abstract class for any puzzle in the game
 */
public abstract class Puzzle extends GameObject {

    private boolean solved = false;

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


    public boolean isSolved() {
        return solved;
    }

    protected void setSolved(boolean solved) {
        this.solved = solved;
    }

    public boolean checkIfDone(Player player){
        if (IntersectionDetector.intersects(player.getHitbox(), this.getHitbox())) {
            if (checkIfHoldingKey(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfHoldingKey(Player player) {
        if (player.getItem() != null) {
            return (player.getItem().getType() == GameObjectType.KEY);
        }
        return false;
    }

}
