package model.npcs;

import model.*;

import java.util.Random;

/**
 * Class that implements the functionality of the NPC dog with gun
 */
public class DogWithGun extends NPC {

    /**
     * Constructor
     *
     * @param name the name of the dog with gun
     */
    public DogWithGun(String name) {
        super(name, GameObjectType.DOGWITHGUN, 0, 0, 625 / 4, 532 / 4);
    }

    public void update() {
    }

    /**
     * Method that handles the dogs barks
     */
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

    /**
     * Method that shows an interaction prompt
     */
    @Override
    public void promptInteraction() {
        notifyAdd(new Text("Pet (E)", Text.TextType.INTERACTION_PROMPT, new Point(getX(), getY())));
    }


}
