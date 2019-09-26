package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InGameView extends View {

    private BufferedImage background;
    private BufferedImage character;
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
    }

    void draw(Graphics g) {
        g.drawImage(background, 0, 0, 1920, 1080, null);
        characterPos = game.getPlayer().getPosition();
        g.drawImage(character, (int) characterPos.getX(), (int) characterPos.getY(), character.getWidth() / 4, character.getHeight() / 4, null);

    }
}
