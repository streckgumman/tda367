package model;

import javax.swing.*;
import java.awt.*;

public class Player extends Charakter {

    public Player(String name) {
        super(name, new Point(1920/2,1080/2));
    }

    public void move(String string) {
        if(string.equals("left")){
            this.setXPosition((int)this.getPosition().getX()-300);
            System.out.println("Moves");
            System.out.println(this.getPosition().toString());
        }
    }
}
