package view;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class View extends JPanel {

    protected final int w, h;
    protected final Game game;

    protected Map<GameObjectType, BufferedImage> gameObjectImages;

    public View(int w, int h, Game game) {
        this.w = w;
        this.h = h;
        this.game = game;
        this.gameObjectImages = new HashMap<GameObjectType, BufferedImage>();
        setFocusable(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(w, h));
        setItemImages();
        setNPCImages();
        setPuzzleImages();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    abstract void draw(Graphics g);

    protected abstract void setItemImages();

    protected abstract void setPuzzleImages();

    protected abstract void setNPCImages();

    protected BufferedImage getGameObjectImage(GameObjectType gameObjectType) {
        BufferedImage gameObjectImage = gameObjectImages.get(gameObjectType);
        if (gameObjectImage == null) {
            try {
                File backgroundPath = new File("./resources/background_1.png");
                gameObjectImage = ImageIO.read(backgroundPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gameObjectImage;
    }
}
