package controller;

import view.InGameView;

import java.awt.event.KeyEvent;

public class PauseMenuUpdater extends Updater {

    private InGameController c;
    private Button[] buttons;
    private int buttonIndex = 0;

    public boolean alreadyClicked = false;

    protected PauseMenuUpdater(InGameController c) {
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
                MainController.getInstance().exitGame();
            }
        };
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP && buttonIndex != 0) {
            buttonIndex--;
            ((InGameView) c.getView()).buttonIndex = buttonIndex;
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN && buttonIndex != buttons.length - 1) {
            buttonIndex++;
            ((InGameView) c.getView()).buttonIndex = buttonIndex;
        } else if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            buttons[buttonIndex].onClick();
        } else if (event.getKeyCode() == KeyEvent.VK_ESCAPE && !alreadyClicked) {
            c.play();
        }
    }

    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            alreadyClicked = false;
        }
    }

    public void keyTyped(KeyEvent event) {

    }
}
