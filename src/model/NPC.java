package model;

public abstract class NPC extends Charakter implements Interactable{

    private NPCType npcType;

    /**
     * Constructor
     * @param name the NPC's name
     * @param npcType the type of npc it is
     */
    public NPC(String name, NPCType npcType, int x, int y, int width, int height) {
        super(name, new Point(x, y), width, height);
        this.npcType = npcType;
    }

    //Shall print out text on the screen when fully implemented
    //For now it just prints to the terminal
    public abstract void talk();

    public void interact(GameObject go){
        talk();
    }

    public NPCType getNpcType() {
        return npcType;
    }
}
