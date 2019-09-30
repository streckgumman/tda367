package model;

import java.awt.*;

public abstract class Trap extends GameObject implements Interactable{


    public Trap() {
        super(new Point(0,0));

    }

    public void activate(){
        //fällan ska aktiveras och spelaren ska få en "debuff"
    }

    public void interact(GameObject go){
        activate();
    }

}
