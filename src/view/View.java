package view;

import model.Game;
import model.ItemType;
import model.NPCType;
import model.PuzzleType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class View extends JPanel {

    protected final int w, h;
    protected final Game game;

    protected Map<ItemType, BufferedImage> itemImages;
    protected Map<NPCType, BufferedImage> npcImages;
    protected Map<PuzzleType, BufferedImage> puzzleImages;

    public View(int w, int h, Game game) {
        this.w = w;
        this.h = h;
        this.game = game;
        this.itemImages = new HashMap<ItemType, BufferedImage>();
        this.npcImages = new HashMap<NPCType, BufferedImage>();
        this.puzzleImages = new HashMap<PuzzleType, BufferedImage>();
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
    protected abstract void setNPCImages();
    protected abstract void setPuzzleImages();

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

    protected BufferedImage getPuzzleImage(PuzzleType puzzleType) {
        BufferedImage puzzleImage = puzzleImages.get(puzzleType);
        if (puzzleImage == null) {
            try {
                File backgroundPath = new File("./resources/background_1.png");
                puzzleImage = ImageIO.read(backgroundPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return puzzleImage;
    }

}
