package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NameInputView extends View {

    public NameInputView() {
        super(1920, 1080, null);
    }

    void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Font font = new Font("Serif", Font.PLAIN, 96);
        g2.setFont(font);

        g2.drawString("Testing is $300", (1920 - g.getFontMetrics().stringWidth("Testing is $300"))/2, 120);
    }

    protected void setItemImages() {

    }

    protected void setNPCImages() {

    }
}

