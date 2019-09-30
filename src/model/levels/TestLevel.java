package model.levels;

import model.ItemType;
import model.Level;
import model.items.TestItem;

public class TestLevel extends Level {

    public TestLevel() {
        addItem(new TestItem("Scissors"));
    }

}
