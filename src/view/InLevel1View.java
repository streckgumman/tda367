package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * <p>
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
     * Gets the background image for level 1
     *
     * @return the background image for level 1
     */
    @Override
    protected BufferedImage getBackgroundImage() {
        return getImage("./resources/background_1.png");
    }


}
