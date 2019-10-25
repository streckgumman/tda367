package view;

import model.Game;

import java.awt.image.BufferedImage;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * <p>
 * Level2View controlls the view that are shown when the game is in level 2
 */
public class Level2View extends InGameView {
    /**
     * The public constructor that creates an instance of the class Level2View
     *
     * @param game the model's game.
     */
    public Level2View(Game game) {
        super(game);
    }

    /**
     * Gets the background image for level 2
     *
     * @return the background image for level 2
     */
    @Override
    protected BufferedImage getBackgroundImage() {
        return getImage("./resources/backgroundLevel2.jpeg");
    }


}
