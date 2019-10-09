package view;

import model.Game;

import java.awt.image.BufferedImage;

public class InLevel2View extends InGameView {
    /**
     * Class constructor.
     *
     * @param game the model's game.
     */
    public InLevel2View(Game game) {
        super(game);
    }

    @Override
    protected BufferedImage setBackground(String background){
        return super.setBackground("./resources/backgroundLevel2.jpeg");
    }



}
