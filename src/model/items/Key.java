package model.items;

import model.GameObjectType;
import model.Item;
import model.Point;
import model.Text;

public class Key extends Item {

    public Key(int x, int y) {
        super("Key", GameObjectType.KEY, x, y, 80, 80);
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
