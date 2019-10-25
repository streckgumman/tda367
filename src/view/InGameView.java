package view;

import model.*;
import model.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class that presents the view while playing the game.
 * <p>
 * Presents the player with graphics, such as the background, the character etc.
 */

public abstract class InGameView extends View implements TextObserver {

    public int buttonIndex = 0;
    int frame = 0;
    boolean paused = false;
    /**
     * Images that represent the game.
     */
    private BufferedImage background;
    private BufferedImage character;
    private BufferedImage flippedCharacter;
    private List<Text> textToDraw = new ArrayList<>();
    private BufferedImage pauseMenuImage;
    private BufferedImage flame;
    private HorizontalDirection lastPlayerDirection;

    /**
     * The public constructor creates an instance of InGameView
     *
     * @param game the model's game.
     */
    public InGameView(Game game) {
        super(1920, 1080, game);

        try {
            File characterPath = new File("./resources/player.png");
            this.character = ImageIO.read(characterPath);

            File pauseMenuPath = new File("./resources/pause_menu.png");
            this.pauseMenuImage = ImageIO.read(pauseMenuPath);

            File flamePath = new File("./resources/flame.png");
            this.flame = ImageIO.read(flamePath);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        background = getBackgroundImage();
        lastPlayerDirection = HorizontalDirection.RIGHT;
        flippedCharacter = horizontalFlip(copyImage(character));
    }

    /**
     * Draws the graphic of the game.
     *
     * @param g the graphic for the view to draw.
     */
    void draw(Graphics g) {
        // Draws the background
        g.drawImage(background, 0, 0, 1920, 1080, null);
        drawItems(g);
        drawNPCs(g);
        drawPuzzles(g);
        drawPlayer(g);
        drawAllText(g);

        if (paused) {
            drawPauseMenu(g);
        }

        frame++;
    }

    /**
     * Draws the player model.
     *
     * @param g the Graphics object to draw on.
     */
    private void drawPlayer(Graphics g) {
        // The direction for having the character face the correct way
        HorizontalDirection currentDirection = getPlayerDirection();

        // Updates variable for use next frame
        lastPlayerDirection = currentDirection;

        // Player position
        int playerX = game.getPlayer().getX();
        int playerY = game.getPlayer().getY();
        int playerYOffset = (int) (10 * Math.sin(Math.PI * frame / 90d));

        // Draws the player facing the correct way
        if (currentDirection == HorizontalDirection.RIGHT) {
            drawPlayerFacingRight(g, playerX, playerY + playerYOffset);
        } else {
            drawPlayerFacingLeft(g, playerX, playerY + playerYOffset);
        }
    }

    /**
     * Method to get the player's direction
     */
    private HorizontalDirection getPlayerDirection() {
        // Variables for where the player is moving, one for each arrow key being pressed
        boolean playerIsMovingRight = game.getPlayer().isMovingRight();
        boolean playerIsMovingLeft = game.getPlayer().isMovingLeft();

        if (playerIsMovingLeft) {
            if (playerIsMovingRight) {
                // Both left and right arrow keys are pressed, player faces the same way as last frame
                return (lastPlayerDirection);
            } else {
                // Only left arrow key is pressed, player faces left
                return (HorizontalDirection.LEFT);
            }
        } else if (playerIsMovingRight) {
            // Only right arrow key is pressed, player faces right
            return (HorizontalDirection.RIGHT);
        } else {
            // No keys are pressed, player faces the same way as last frame
            return (lastPlayerDirection);
        }
    }

    /**
     * Draws the player model facing right.
     *
     * @param g       the Graphics object to draw on.
     * @param playerX where on the X-axis to draw the player model.
     * @param playerY where on the Y-axis to draw the player model.
     */
    private void drawPlayerFacingRight(Graphics g, int playerX, int playerY) {
        g.drawImage(character, playerX, playerY, character.getWidth() / 4, character.getHeight() / 4, null);
    }

    /**
     * Draws the player model facing left.
     *
     * @param g       the Graphics object to draw on.
     * @param playerX where on the X-axis to draw the player model.
     * @param playerY where on the Y-axis to draw the player model.
     */
    private void drawPlayerFacingLeft(Graphics g, int playerX, int playerY) {
        g.drawImage(flippedCharacter, playerX, playerY, character.getWidth() / 4, character.getHeight() / 4, null);
    }

    /**
     * Method to graphically draw all Items in the game
     *
     * @param g
     */
    private void drawItems(Graphics g) {
        for (Item i : game.getLevel().getItems()) {
            g.drawImage(gameObjectImages.get(i.getType()), i.getX(), i.getY(), i.getWidth(), i.getHeight(), null);
        }
    }

    /**
     * Method to graphically draw all NPCs in the game
     *
     * @param g
     */
    private void drawNPCs(Graphics g) {
        for (NPC npc : game.getLevel().getNpcs()) {
            g.drawImage(gameObjectImages.get(npc.getType()), npc.getX(), npc.getY(), npc.getWidth(), npc.getHeight(), null);
        }
    }

    /**
     * Method to graphically draw all Puzzles in the game
     *
     * @param g
     */
    private void drawPuzzles(Graphics g) {
        for (Puzzle puzzle : game.getLevel().getPuzzles()) {
            g.drawImage(gameObjectImages.get(puzzle.getType()), puzzle.getX(), puzzle.getY(), puzzle.getHitbox().getWidth(), puzzle.getHitbox().getHeight(), null);
        }
    }

    /**
     * Method to graphically draw the Pause menu
     * and the indicator that shows which option is selected
     *
     * @param g
     */
    private void drawPauseMenu(Graphics g) {
        g.drawImage(pauseMenuImage, (1920 - pauseMenuImage.getWidth()) / 2, (1080 - pauseMenuImage.getHeight()) / 2, null);

        int flameX = 1920 / 2 + 300;
        int flameY = 340 + buttonIndex * 300;
        g.drawImage(flame, flameX, flameY, null);
    }


    /**
     * Method to set the images for the items in the game.
     */
    private void drawAllText(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for (int i = textToDraw.size() - 1; i >= 0; i--) {
            Text text = textToDraw.get(i);
            Font font = determineFont(text.getType());
            g2.setFont(font);
            g2.drawString(text.getText(), text.getPosition().getX(), text.getPosition().getY());
        }
    }


    protected void setItemImages() {
        gameObjectImages.put(GameObjectType.SCISSORS, getImage("./resources/scissors.png"));
        gameObjectImages.put(GameObjectType.KEY, getImage("./resources/key.png"));
        gameObjectImages.put(GameObjectType.HAMMER, getImage("./resources/hammer.png"));
    }

    /**
     * Method to set the images for the NPCs in the game.
     */
    protected void setNPCImages() {
        try {
            File backgroundPath = new File("./resources/dog_with_gun.png");
            gameObjectImages.put(GameObjectType.DOGWITHGUN, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to set the images for the Puzzles in the game.
     */
    protected void setPuzzleImages() {
        try {
            File backgroundPath = new File("./resources/door.png");
            gameObjectImages.put(GameObjectType.DOOR, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File backgroundPath = new File("./resources/bush.png");
            gameObjectImages.put(GameObjectType.BUSH, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File backgroundPath = new File("./resources/rock.png");
            gameObjectImages.put(GameObjectType.ROCK, ImageIO.read(backgroundPath));
        } catch (IOException e) {
            e.printStackTrace();
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

    /**
     * Method to flip the images for the Puzzles in the game.
     */
    private BufferedImage horizontalFlip(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
    }

    @Override
    public void actOnTextAdd(Text text) {
        int size = determineFont(text.getType()).getSize();
        //When you draw text at (x,y), the bottom left of the text will be placed at (x,y), unlike EVERYTHING ELSE, where the top left is placed at (x,y).
        //This leads to text effectively being offset by the height of the characters, therefore we have to counter that offset by adding the size of the text.
        text.setPosition(new Point(text.getPosition().getX(), text.getPosition().getY() + size));
        textToDraw.add(text);
    }

    @Override
    public void actOnTextRemove(Text text) {
        textToDraw.remove(text);
    }

    private Font determineFont(Text.TextType type) {
        switch (type) {
            case DIALOGUE:
                return new Font("SansSerif", Font.PLAIN, 48);
            case INTERACTION_PROMPT:
                return new Font("SansSerif", Font.ITALIC, 48);
        }
        return null; //If type didn't match, we have no font to return
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Abstract method to get the background image for subclasses
     *
     * @return the background image
     */
    protected abstract BufferedImage getBackgroundImage();

    private enum HorizontalDirection {
        RIGHT,
        LEFT
    }


}
