package model.levels;

import model.ItemType;
import model.Level;
import model.NPCType;
import model.items.TestItem;
import model.npcs.DogWithGun;

public class TestLevel extends Level {

    public TestLevel() {
        addItem(new TestItem("Scissors"));
        addNPC(new DogWithGun("Dog with gun"));
    }

}
