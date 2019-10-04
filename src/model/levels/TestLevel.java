package model.levels;

import model.Level;
import model.items.Key;
import model.items.Scissors;
import model.npcs.DogWithGun;

public class TestLevel extends Level {

    public TestLevel() {
        addItem(new Scissors("Scissors", 200, 300));
        addItem(new Key(1920 / 2, 1080 / 2));
        addNPC(new DogWithGun("Dog with gun"));
    }

}
