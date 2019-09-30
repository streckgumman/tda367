package model;

import java.awt.*;

public abstract class Puzzle extends GameObject implements Interactable{
    private boolean solved = false;
    public Puzzle() {
        super(new Point(0,0));
    }

    //vet inte om detta (under) ska vara kvar
    public void something(){
        //Världen ska vända tillbaka sig rätt och dörren till nästa nivå ska öppnas
    }

    public void interact(GameObject go){
        something();
    }


}
