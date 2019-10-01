package model;

import java.awt.*;

public abstract class NPC extends Charakter implements Interactable{

    private NPCType npcType;

    public NPC(String name, NPCType npcType) {
        super(name, new Point(0, 0));
        this.npcType = npcType;
    }

    public void talk(){
        //npc'n ska starta en dialog med spelaren
    }

    public void interact(GameObject go){
        talk();
    }

    public NPCType getNpcType() {
        return npcType;
    }
}
