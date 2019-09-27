package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class that presents the view while playing the game.
 *
 * Presents the player with graphics, such as the background, the character etc.
 *
 * @author Amanda Dehlén, Linnea Johansson
 *
 */

public class InGameView extends View {

    private BufferedImage background;
    private BufferedImage character;

    public InGameView(Game game) {
        super(1920, 1080, game);

        try {
            File backgroundPath = new File("./resources/background_1.png");
            this.background = ImageIO.read(backgroundPath);

            File characterPath = new File("./resources/player.png");
            this.character = ImageIO.read(characterPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void draw(Graphics g) {
        g.drawImage(background, 0, 0, 1920, 1080, null);
        int playerX = game.getPlayer().getX();
        int playerY = game.getPlayer().getY();
        g.drawImage(character, playerX, playerY, character.getWidth() / 4, character.getHeight() / 4, null);

    }
}
