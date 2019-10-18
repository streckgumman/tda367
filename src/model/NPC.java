package model;

public abstract class NPC extends Charakter {

    private Text lastLine;

    /**
     * Constructor
     *
     * @param name the NPC's name
     * @param type the type of game Object it is
     */
    public NPC(String name, GameObjectType type, int x, int y, int width, int height) {
        super(name, x, y, width, height, type);
    }

    public abstract void talk();

    public void interact(GameObject go) {
        talk();
    }

    /**
     * Call actOnTextAdd for all observers, with text as the argument.
     *
     * @param text The Text that is passed as the argument to the observers.
     */
    @Override
    public void notifyAdd(Text text) {
        stopTalking();
        lastLine = text;
        super.notifyAdd(text);
    }

    /**
     * Send remove request with the last spoken Text as the argument.
     */
    public void stopTalking() {
        notifyRemove(lastLine);
    }

}
