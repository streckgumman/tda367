package model.puzzles;

import model.GameObjectType;
import model.Item;
import model.Player;
import model.Puzzle;
import model.items.Key;

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
                System.out.println("Door is solved");

                return true;
            }
        }
        return false;
    }

    protected Item getMyItem() {
        return new Key(1920 / 2, 1080 / 2);
    }


}
