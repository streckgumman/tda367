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

public class InGameView extends View {

    private BufferedImage background;
    private BufferedImage character;
    private BufferedImage flippedCharacter;
    private Point characterPos;

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

        flippedCharacter = horizontalFlip(copyImage(character));
    }

    void draw(Graphics g) {
        g.drawImage(background, 0, 0, 1920, 1080, null);
        int playerX = game.getPlayer().getX();
        int playerY = game.getPlayer().getY();
        characterPos = game.getPlayer().getPosition();
        if (game.getPlayer().isMovingRight()) {
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
