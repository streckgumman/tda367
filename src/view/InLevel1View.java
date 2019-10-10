package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * InLevel1View controlls the view that are shown when the game is in level 1
 */
public class InLevel1View extends InGameView {
    /**
     * The public constructor for the class InLevel1View
     *
     * @param game the model's game.
     */
    public InLevel1View(Game game) {
        super(game);
    }

    /**
     * Overrides the setBackground method in it's superclass InGameView and are used to set the right background
     * @return the image that should be set as the background in level 1
     */
    protected BufferedImage setBackground(String dummy){
        return super.setBackground("./resources/background_1.png");
    }




}
