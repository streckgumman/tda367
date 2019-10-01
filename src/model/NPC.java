package model;

import java.awt.*;

public abstract class NPC extends Charakter implements Interactable{

    public NPC(String name, int x, int y, int width, int height) {
        super(name, new Point(x, y), width, height);
    }

    public void talk(){
        //npc'n ska starta en dialog med spelaren
    }

    public void interact(GameObject go){
        talk();
    }


}
