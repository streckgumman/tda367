package controller;

import view.InGameView;

import java.awt.event.KeyEvent;

/**
 * @author Anna Nilsson
 * @author Johannes Kvernes
 * <p>
 * Abstract class for all puzzles in the game
 */
public class PauseMenuUpdater extends Updater {

    private GameStateChanger stateChanger;
    private InGameView v;
    private Button[] buttons;
    private int buttonIndex = 0;


    boolean alreadyClicked = false;


    /**
     * Constructor
     *
     * @param stateChanger an interface containing the InGameController's play() method
     * @param gameExiter   an interface containing the games exit() method
     * @param v            the current InGameView which will display the pause menu
     */
    protected PauseMenuUpdater(GameStateChanger stateChanger, GameExiter gameExiter, InGameView v) {
        super(null);
        this.stateChanger = stateChanger;
        this.v = v;
        this.buttons = new Button[2];

        buttons[0] = new Button() {
            @Override
            public void onClick() {
                stateChanger.changeGameState();
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
                    v.buttonIndex = buttonIndex;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (buttonIndex != buttons.length - 1) {
                    buttonIndex++;
                    v.buttonIndex = buttonIndex;
                }
                break;
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_E:
                buttons[buttonIndex].onClick();
                break;
            case KeyEvent.VK_ESCAPE:
                if (!alreadyClicked) {
                    stateChanger.changeGameState();
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
