package model.puzzles;

import model.GameObjectType;
import model.Player;
import model.Puzzle;

public class Door extends Puzzle {
    /**
     * The public constructor for the class Door
     *
     * The class Door extends the class Puzzle
     *
     * @param x the position of the Door in x axis
     * @param y the position of the Door in y axis
     * @param width the width of the Door's hitbox
     * @param height the height of the Door's hitbox
     */
    public Door(int x, int y, int width, int height) {
        super(x, y, width, height, GameObjectType.DOOR);
    }

    @Override
    protected void update() {

    }

    @Override
    protected boolean checkIfHoldingItem(Player player) {
        if (player.getItem() != null) {
            if(player.getItem().getType() == GameObjectType.KEY){
                setSolved(true);
                return true;
            }
        }
        return false;
    }



}
