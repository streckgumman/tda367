package model.items;

import model.GameObjectType;
import model.Item;
import model.Point;
import model.Text;

public class Scissors extends Item {

    public Scissors(String name, int x, int y) {
        super(name, GameObjectType.SCISSORS, x, y, 80, 80);
    }

    public void update() {

    }

    @Override
    public void promptInteraction() {
        notifyAdd(new Text("Pick up (E)", Text.TextType.INTERACTION_PROMPT, new Point(getX(), getY())));
    }

    public void use() {

    }
}
