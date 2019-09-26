package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InGameView extends View {

    public InGameView(Game game) {
        super(1920, 1080, game);
    }

    void draw(Graphics g) {
        try {
            File pathToFile = new File("./resources/background_1.png");
            Image image = ImageIO.read(pathToFile);
            g.drawImage(image, 0, 0, 1920, 1080, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            File pathToFile = new File("./resources/player.png");
            BufferedImage image = ImageIO.read(pathToFile);
            Point point = game.getPlayer().getPosition();
            g.drawImage(image, (int)point.getX(), (int)point.getY(), image.getWidth() / 4, image.getHeight() / 4, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
