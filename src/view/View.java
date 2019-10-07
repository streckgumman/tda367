package view;

import model.Game;
import model.ItemType;
import model.NPCType;
import model.Point;

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

    protected Map<ItemType, BufferedImage> itemImages;
    protected Map<NPCType, BufferedImage> npcImages;

    public View(int w, int h, Game game) {
        this.w = w;
        this.h = h;
        this.game = game;
        this.itemImages = new HashMap<ItemType, BufferedImage>();
        this.npcImages = new HashMap<NPCType, BufferedImage>();
        setFocusable(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(w, h));
        setItemImages();
        setNPCImages();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    abstract void draw(Graphics g);

    protected abstract void setItemImages();

    protected abstract void setNPCImages();

    protected BufferedImage getItemImage(ItemType itemType) {
        BufferedImage itemImage = itemImages.get(itemType);
        if (itemImage == null) {
            try {
                File backgroundPath = new File("./resources/background_1.png");
                itemImage = ImageIO.read(backgroundPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return itemImage;
    }

    protected BufferedImage getNPCImage(NPCType npcType) {
        BufferedImage npcImage = npcImages.get(npcType);
        if (npcImage == null) {
            try {
                File backgroundPath = new File("./resources/background_1.png");
                npcImage = ImageIO.read(backgroundPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return npcImage;
    }

}
