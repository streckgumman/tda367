package model.npcs;

import model.NPC;
import model.NPCType;
import model.Point;
import model.Text;

import java.util.Random;

public class DogWithGun extends NPC {

    public DogWithGun(String name) {
        super(name, NPCType.DOGWITHGUN, 0, 0, 625 / 4, 532 / 4);
    }

    protected void update() {

    }

    @Override
    public void talk() {
        String[] dialogues = {"BA", "woof!", "Wan"};
        String bark = "";
        Random r = new Random();
        int randInt = r.nextInt(dialogues.length);
        for (int i = 0; i < dialogues.length; i++) {
            if (i == randInt) {
                bark = dialogues[i];
            }
        }
        notifyAdd(new Text(bark, Text.TextType.DIALOGUE, new Point(getX(), getY())));
    }

}
