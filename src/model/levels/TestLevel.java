package model.levels;

import model.ItemType;
import model.Level;
import model.NPCType;
import model.items.Key;
import model.items.TestItem;
import model.npcs.DogWithGun;

public class TestLevel extends Level {

    public TestLevel() {
        addItem(new TestItem("Scissors", 200, 300));
        addItem(new Key(1920 / 2, 1080 / 2));
        addNPC(new DogWithGun("Dog with gun"));
    }

}
