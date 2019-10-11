package model;

public abstract class NPC extends Charakter {

    private NPCType npcType;

    /**
     * Constructor
     * @param name the NPC's name
     * @param npcType the type of npc it is
     */
    public NPC(String name, NPCType npcType, int x, int y, int width, int height) {
        super(name, x, y, width, height);
        this.npcType = npcType;
    }

    public abstract void talk();

    public void interact(GameObject go){
        talk();
    }

    public NPCType getNpcType() {
        return npcType;
    }
}
