package model.npcs;

import model.NPC;
import model.NPCType;

import java.util.Random;

public class DogWithGun extends NPC {

    public DogWithGun(String name) {
        super(name, NPCType.DOGWITHGUN, 0, 0, 625 / 4, 532 / 4);
    }

    protected void update() {

    }

    @Override
    public void talk(){
        String[] dialogues = {"BA", "woof!", "Wan"};
        String bark = "";
        Random r = new Random();
        int randInt = r.nextInt(dialogues.length);
        for (int i = 0; i < dialogues.length; i++) {
            if (i == randInt) {
                bark = dialogues[i];
            }
        }
        System.out.println(bark);
        //Här ska vi lägga till så att någon vet att de ska skriva text i spelet....
    }

}
