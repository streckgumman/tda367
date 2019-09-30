package model;

import java.awt.*;

public abstract class Item extends GameObject implements Interactable{
    private String name;
    public Item(String name) {
        super(new Point(0,0));
        this.name = name;
    }

    public void pickup(Player player){
        //ska lägga till objektet i spelarens ryggsäck
        player.pickUpItem(this);
    }

    public void drop(){

        //ska släppa objektet på "marken", ge tillbaka det till level
        //behöver ha tillgång till leveln
    }

    public abstract void use();



    public void interact(GameObject go){
        // bad code, will be changed
        if (go instanceof Player) {
            pickup((Player) go);
        }
    }

}
