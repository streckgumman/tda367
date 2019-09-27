package view;

import model.Game;
import model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class that presents the view while playing the game.
 * <p>
 * Presents the player with graphics, such as the background, the character etc.
 *
 * @author Amanda Dehlén, Linnea Johansson
 */

public class InGameView extends View {

    /**
     * Images that represent the game.
     */
    private BufferedImage background;
    private BufferedImage character;
    private BufferedImage flippedCharacter;

    private enum horizontalDirection {
        RIGHT,
        LEFT
    }

    private horizontalDirection lastPlayerDirection;

    /**
     * Class constructor.
     *
     * @param game  the model's game.
     */
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

        lastPlayerDirection = horizontalDirection.RIGHT;

        flippedCharacter = horizontalFlip(copyImage(character));
    }

    /**
     * Draws the graphic of the game.
     *
     * @param g the graphic for the view to draw.
     */
    void draw(Graphics g) {
        g.drawImage(background, 0, 0, 1920, 1080, null);
        int playerX = game.getPlayer().getX();
        int playerY = game.getPlayer().getY();
        boolean playerIsMovingRight = game.getPlayer().isMovingRight();
        boolean playerIsMovingLeft = game.getPlayer().isMovingLeft();

        horizontalDirection currentDirection;
        if (playerIsMovingLeft) {
            if (playerIsMovingRight) {
                currentDirection = lastPlayerDirection;
            } else {
                currentDirection = horizontalDirection.LEFT;
            }
        } else if (playerIsMovingRight) {
            currentDirection = horizontalDirection.RIGHT;
        } else {
            currentDirection = lastPlayerDirection;
        }
        lastPlayerDirection = currentDirection;


        if (currentDirection == horizontalDirection.RIGHT) {
            g.drawImage(character, playerX, playerY, character.getWidth() / 4, character.getHeight() / 4, null);
        } else {
            g.drawImage(flippedCharacter, playerX, playerY, character.getWidth() / 4, character.getHeight() / 4, null);
        }
    }

    //TODO These (copyImage and horizontalFlip) methods might not belong in this class?
    private BufferedImage copyImage(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    private BufferedImage horizontalFlip(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
    }
}
