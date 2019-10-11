package view;

import model.Game;
import model.Text;

import java.awt.*;
import java.awt.geom.Line2D;

public class NameInputView extends View {

    private int frame = 0;

    public NameInputView(Game game) {
        super(1920, 1080, game);
    }

    void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 96);
        g2.setFont(font);
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.drawString("Please enter your name", (1920 - g.getFontMetrics().stringWidth("Please enter your name")) / 2, 200);

        Font playerNameFont = new Font("SansSerif", Font.PLAIN, 96);
        g2.setFont(playerNameFont);
        g2.drawString(game.getPlayer().getName(), (1920 - g.getFontMetrics().stringWidth(game.getPlayer().getName())) / 2, 800);
        int rightMostCharacterXCoordinate = ((1920 - g.getFontMetrics().stringWidth(game.getPlayer().getName())) / 2 + g.getFontMetrics().stringWidth(game.getPlayer().getName()));
        if (frame % 120 < 60) { //Only draw the text cursor every other second (assumes 60fps)
            Shape line = new Line2D.Double(rightMostCharacterXCoordinate, 800, rightMostCharacterXCoordinate, 800 - g.getFontMetrics().getHeight() / 2.0);
            g2.draw(line);
        }
        frame++;
    }

    @Override
    protected void setItemImages() {

    }

    @Override
    protected void setPuzzleImages() {

    }

    @Override
    protected void setNPCImages() {

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

