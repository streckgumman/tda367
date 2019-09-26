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
        }
        if(string.equals("right")){
            this.setXPosition((int)this.getPosition().getX()+10);
            System.out.println(this.getPosition().toString());
        }
        if(string.equals("up")){
            this.setYPosition((int)this.getPosition().getY()-10);
            System.out.println(this.getPosition().toString());
        }
        if(string.equals("down")){
            this.setYPosition((int)this.getPosition().getY()+10);
            System.out.println(this.getPosition().toString());
        }
    }
}
