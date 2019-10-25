package view;

import model.Game;

import java.awt.image.BufferedImage;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * <p>
 * Level3View controlls the view that are shown when the game is in level 3
 */
public class Level3View extends InGameView {
    /**
     * The public constructor that creates an instance of the class Level3View
     *
     * @param game the model's game.
     */
    public Level3View(Game game) {
        super(game);
    }

    /**
     * Gets the background image for level 3
     *
     * @return the background image for level 3
     */
    @Override
    protected BufferedImage getBackgroundImage() {
        return getImage("./resources/batman.jpg");
    }


}
