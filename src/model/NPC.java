package model;

import java.awt.*;

public abstract class NPC extends Charakter {

    public NPC(String name) {
        super(name, new Point(0,0));
    }
}
