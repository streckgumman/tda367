package view;

import model.Game;

import java.awt.image.BufferedImage;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * InLevel2View controlls the view that are shown when the game is in level 2
 */
public class InLevel2View extends InGameView {
    /**
     * The public constructor that creates an instance of the class InLevel2View
     * @param game the model's game.
     */
    public InLevel2View(Game game) {
        super(game);
    }

    /**
     * @return the image that should be set as the background in level 2
     */
    protected BufferedImage setBackground(String dummy){
        return super.setBackground("./resources/backgroundLevel2.jpeg");
    }



}
