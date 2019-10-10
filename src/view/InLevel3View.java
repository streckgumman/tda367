package view;

import model.Game;

import java.awt.image.BufferedImage;
/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * InLevel3View controlls the view that are shown when the game is in level 3
 */
public class InLevel3View extends InGameView{
    /**
     * The public constructor that creates an instance of the class InLevel3View
     * @param game the model's game.
     */
    public InLevel3View(Game game) {
        super(game);
    }

    /**
     * Overrides the setBackground method in it's superclass InGameView and are used to set the right background
     * @return the image that should be set as the background in level 3
     */
    protected BufferedImage setBackground(String dummy){
        return super.setBackground("./resources/batman.jpg");
    }


}
