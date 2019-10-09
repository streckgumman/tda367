package view;

import model.Game;

import java.awt.image.BufferedImage;

public class InLevel3View extends InGameView{

    public InLevel3View(Game game) {
        super(game);
    }

    @Override
    protected BufferedImage setBackground(String background){
        return super.setBackground("./resources/batman.jpg");
    }


}
