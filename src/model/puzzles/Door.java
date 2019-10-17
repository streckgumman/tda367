package model.puzzles;

import model.GameObjectType;
import model.Point;
import model.Puzzle;
import model.Text;

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
    public void update() {

    }

    @Override
    public void promptInteraction() {
        notifyAdd(new Text("Open (E)", Text.TextType.INTERACTION_PROMPT, new Point(getX(), getY())));
        //@TODO if the player doesn't have a key, instead print "The door is locked"
    }

}
