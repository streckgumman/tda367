package model.npcs;

import model.NPC;
import model.NPCType;

public class DogWithGun extends NPC {

    public DogWithGun(String name) {
        super(name, NPCType.DOGWITHGUN, 0, 0, 625 / 4, 532 / 4);
    }

    protected void update() {

    }

    @Override
    public void talk(){
        String welcome = "BA";
        System.out.println(welcome);
    }

}
