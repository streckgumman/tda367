package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InLevel1View extends InGameView {
    /**
     * Class constructor.
     *
     * @param game the model's game.
     */
    public InLevel1View(Game game) {
        super(game);
    }


    @Override
    protected BufferedImage setBackground(String background){
        return super.setBackground("./resources/background_1.png");
    }




}
