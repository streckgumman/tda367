package view;

import model.Text;

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
        super(1920, 1080, null);

        try {
            File backgroundPath = new File("./resources/start_menu.png");
            this.background = ImageIO.read(backgroundPath);

            File pressEPath = new File("./resources/press_e.png");
            this.pressE = ImageIO.read(pressEPath);

            File characterPath = new File("./resources/player.png");
            this.character = ImageIO.read(characterPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void draw(Graphics g) {
        // Draws the background
        g.drawImage(background, 0, 0, 1920, 1080, null);

        // Sets the alpha channel for the coming graphics operations
        // Specifically, the alpha goes up and down with time, creating a fading in and out look for the "press e" image
        float alpha = (float) (Math.sin(Math.PI * frame / 120d) + 3) / 4; //draw half transparent
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(ac);

        // Determines how far from the bottom the "press e" image will be
        int bottomPadding = 50;
        // Draws the "press e" image
        g.drawImage(pressE, 1920 / 2 - pressE.getWidth() / 2, 1080 - pressE.getHeight() - bottomPadding, null);

        // Sets the alpha channel back to 100%
        AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
        g2d.setComposite(opaque);

        // Determines where the character will be displayed, floats up and down the screen with time
        int characterYOffset = (int) (100 * Math.sin(Math.PI * frame / 180d));
        // Draws the character image
        g.drawImage(character, 1920 - 200, 400 + characterYOffset, -character.getWidth() / 4, character.getHeight() / 4, null);

        // Increases frame variable to be used with alpha and character position
        frame += 1;
    }

    protected void setItemImages() {

    }

    protected void setNPCImages() {

    }

    protected void setPuzzleImages() {

    }

    @Override
    public void actOnTextAdd(Text text) {
        //Do stuff
    }

    @Override
    public void actOnTextRemove(Text text) {
        //Do stuff
    }
}
