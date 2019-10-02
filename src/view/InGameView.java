package view;

import model.*;

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

    private enum HorizontalDirection {
        RIGHT,
        LEFT
    }

    /**
     * Images that represent the game.
     */
    private BufferedImage background;
    private BufferedImage character;
    private BufferedImage flippedCharacter;

    private HorizontalDirection lastPlayerDirection;
    int frame = 0;

    /**
     * Class constructor.
     *
     * @param game the model's game.
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

        lastPlayerDirection = HorizontalDirection.RIGHT;
        flippedCharacter = horizontalFlip(copyImage(character));
    }

    /**
     * Draws the graphic of the game.
     *
     * @param g the graphic for the view to draw.
     */
    void draw(Graphics g) {
        // Draws the background
        g.drawImage(background, 0, 0, 1920, 1080, null);

        // Variables for where the player is moving, one for each arrow key being pressed
        boolean playerIsMovingRight = game.getPlayer().isMovingRight();
        boolean playerIsMovingLeft = game.getPlayer().isMovingLeft();

        // The direction for having the character face the correct way
        HorizontalDirection currentDirection;

        if (playerIsMovingLeft) {
            if (playerIsMovingRight) {
                // Both left and right arrow keys are pressed, player faces the same way as last frame
                currentDirection = lastPlayerDirection;
            } else {
                // Only left arrow key is pressed, player faces left
                currentDirection = HorizontalDirection.LEFT;
            }
        } else if (playerIsMovingRight) {
            // Only right arrow key is pressed, player faces right
            currentDirection = HorizontalDirection.RIGHT;
        } else {
            // No keys are pressed, player faces the same way as last frame
            currentDirection = lastPlayerDirection;
        }

        // Updates variable for use next frame
        lastPlayerDirection = currentDirection;

        // Player position
        int playerX = game.getPlayer().getX();
        int playerY = game.getPlayer().getY();
        int playerYOffset = (int) (10 * Math.sin(Math.PI * frame / 90d));

        // Draws the player facing the correct way
        if (currentDirection == HorizontalDirection.RIGHT) {
            g.drawImage(character, playerX, playerY + playerYOffset, character.getWidth() / 4, character.getHeight() / 4, null);
        } else {
            g.drawImage(flippedCharacter, playerX, playerY + playerYOffset, character.getWidth() / 4, character.getHeight() / 4, null);
        }


        for (Item i : game.getLevel().getItems()) {
            g.drawImage(itemImages.get(i.getType()), i.getX(), i.getY(), null);
        }

        for (NPC npc : game.getLevel().getNpcs()){
            g.drawImage(npcImages.get(npc.getNpcType()), npc.getX(), npc.getY(), null);
        }


        frame++;
    }

    protected void setItemImages() {
        try {
            File backgroundPath = new File("./resources/scissors.png");
            itemImages.put(ItemType.SCISSORS, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File backgroundPath = new File("./resources/key.png");
            itemImages.put(ItemType.KEY, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setNPCImages() {
        try {
            File backgroundPath = new File("./resources/dog_with_gun.png");
            npcImages.put(NPCType.DOGWITHGUN, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
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
