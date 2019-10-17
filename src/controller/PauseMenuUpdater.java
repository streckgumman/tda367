package controller;

import view.InGameView;

import java.awt.event.KeyEvent;

public class PauseMenuUpdater extends Updater {

    private InGameController c;
    private Button[] buttons;
    private int buttonIndex = 0;


    boolean alreadyClicked = false;


    /**
     * Constructor
     *
     * @param c the inGameController
     */
    protected PauseMenuUpdater(final InGameController c, GameExiter gameExiter) {
        super(null);
        this.c = c;
        this.buttons = new Button[2];

        buttons[0] = new Button() {
            @Override
            public void onClick() {
                c.play();
            }
        };

        buttons[1] = new Button() {
            @Override
            public void onClick() {
                gameExiter.exit();
            }
        };
    }


    /**
     * Handles key input
     */
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (buttonIndex != 0) {
                    buttonIndex--;
                    ((InGameView) c.getView()).buttonIndex = buttonIndex;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (buttonIndex != buttons.length - 1) {
                    buttonIndex++;
                    ((InGameView) c.getView()).buttonIndex = buttonIndex;
                }
                break;
            case KeyEvent.VK_ENTER:
                buttons[buttonIndex].onClick();
                break;
            case KeyEvent.VK_ESCAPE:
                if (!alreadyClicked) {
                    c.play();
                }
                break;
        }
    }


    /**
     * Handles key input
     */
    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            alreadyClicked = false;
        }
    }

    public void keyTyped(KeyEvent event) {

    }
}
