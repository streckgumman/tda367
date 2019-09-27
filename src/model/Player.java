package model;

import javax.swing.*;
import java.awt.*;

public class Player extends Charakter {

    public Player(String name) {
        super(name, new Point(1920/2,1080/2));
    }

    public void move(String string) {
        if(string.equals("left")){
            this.setXPosition((int)this.getPosition().getX()-10);
            System.out.println(this.getPosition().toString());
    @Override
    public void update() {
        int dx = 0;
        int dy = 0;
        if (movingRight) {
            dx += 10;
        }
        if (movingLeft) {
            dx -= 10;
        }
        if (movingUp) {
            dy -= 10;
        }
        if (movingDown) {
            dy += 10;
        }
        move(dx, dy);
    }
    }
}
