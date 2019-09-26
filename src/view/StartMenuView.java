package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenuView extends View {

    private BufferedImage background;
    private BufferedImage pressE;
    private BufferedImage character;
    private int frame = 0;

    public StartMenuView() {
        super(1920, 1080);

        try {
            File backgroundPath = new File("./resources/Starting menu.png");
            this.background = ImageIO.read(backgroundPath);

            File pressEPath = new File("./resources/Press_e_to_start.png");
            this.pressE = ImageIO.read(pressEPath);

            File characterPath = new File("./resources/player.png");
            this.character = ImageIO.read(characterPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void draw(Graphics g) {
        int backgroundPadding = 50;
        g.drawImage(background, 0, 0, 1920, 1080, null);

        float alpha = (float) (Math.sin(Math.PI * frame / 120d) + 3) / 4; //draw half transparent
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);

        g.drawImage(pressE, 1920 / 2 - pressE.getWidth() / 2, 1080 - pressE.getHeight() - backgroundPadding, null);

        AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
        g2d.setComposite(opaque);

        int characterYOffset = (int) (100 * Math.sin(Math.PI * frame / 180d));
        g.drawImage(character, 1920 - 200, 400 + characterYOffset, -character.getWidth() / 4, character.getHeight() / 4, null);
        frame += 1;
    }
}
