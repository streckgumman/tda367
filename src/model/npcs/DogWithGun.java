package model.npcs;

import model.NPC;
import model.NPCType;

public class DogWithGun extends NPC {

    public DogWithGun(String name) {
        super(name, NPCType.DOGWITHGUN);
    }

    protected void update() {

    }

    @Override
    public void talk(){
        String welcome = "Welcome to the game";
    }

}
