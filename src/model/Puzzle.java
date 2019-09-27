package model;

import java.awt.*;

public abstract class Puzzle extends GameObject {

    private boolean solved = false;

    public Puzzle() {
        super(new Point(0, 0));
    }
}
