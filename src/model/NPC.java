package model;

import java.awt.*;

public abstract class NPC extends Charakter implements Interactable{

    public NPC(String name) {
        super(name, new Point(0, 0));
    }

    public void talk(){
        //npc'n ska starta en dialog med spelaren
    }

    public void interact(GameObject go){
        talk();
    }


}
