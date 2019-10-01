package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {

    Player player;
    List<NPC> npcs;
    List<Puzzle> puzzles;
    List<Trap> traps;
    List<Item> items;

    public Level() {
        npcs = new ArrayList<NPC>();
        puzzles = new ArrayList<Puzzle>();
        traps = new ArrayList<Trap>();
        items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void addNPC(NPC npc){
        npcs.add(npc);
    }

    public List<NPC> getNpcs(){
        return npcs;
    }
}
