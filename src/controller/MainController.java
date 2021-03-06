package controller;

import model.Game;
import view.*;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The "overlord" of controllers, responsible for switching which one is active, as well as which view is shown.
 */
public class MainController extends Updater {


    private final Game game;
    private JFrame frame;
    private View view;
    /**
     * The currently active controller.
     */
    private Controller c;
    private boolean running;

    private int windowWidth;
    private int windowHeight;

    /**
     * Constructor
     */
    public MainController() {
        super(null);
        game = new Game();
        frame = new JFrame();

        windowWidth = 1920; //For now the width and height is 1920x1080, but it could easily take an argument from settings instead
        windowHeight = 1080;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Creates a window with the content of StartMenuView and makes StartMenuController the active controller. (shows the start menu)
     */
    public void startGame() {
        frame.add(view = new StartMenuView());

        frame.setSize(windowWidth, windowHeight - 100);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

        c = new StartMenuController(view, this::switchToNameInput, this::exitGame);
        c.addUpdater(this);
        view.addKeyListener(c);

        runGame();
    }

    /**
     * The core loop of the game, updating the model and view approximately 60 times per second.
     */
    private void runGame() {
        running = true;
        // Calls the sub-controller's update method 60 times per second (ideally)
        while (running) {
            long startTime = System.currentTimeMillis();
            c.update();
            long totalTime = System.currentTimeMillis() - startTime;
            if (totalTime < 16) {
                try {
                    Thread.sleep(16 - totalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * Switches view to the in-game view, and makes InGameController the active controller. (Changes to the screen where you play the game)
     */
    public void switchToIngame() {
        view = new Level1View(game);
        switchView(view, new InGameController(view, game, this::exitGame, this::switchToNextLevelView));
    }

    /**
     * Switches the current view to the next levels view
     */
    public void switchToNextLevelView() {
        int level = game.getCurrentLevelsNrInLine();
        switch (level) {
            case 1:
                view = new Level2View(game);
                break;
            case 2:
                view = new Level3View(game);
                break;
            default:
                view = null;
        }
        switchView(view, new InGameController(view, game, this::exitGame, this::switchToNextLevelView));
    }

    /**
     * General method for switching views
     */
    private void switchView(View view, Controller c) {
        frame.remove(this.view); //I don't know why this is necessary, but I could not get it to work without first removing the view and then adding it again. /Vargen
        this.view = view;
        frame.add(view);
        frame.validate(); //Removing the view invalidates the frame, so we need to validate it in order to display it again.

        view.removeKeyListener(this.c);
        this.c = c;
        view.addKeyListener(c);
        view.requestFocus(); //This is required in order to register user input again.
    }

    /**
     * Switches the view to the NameInput view
     */
    public void switchToNameInput() {
        view = new NameInputView(game);
        switchView(view, new NameInputController(view, getGame(), this::switchToIngame, this::exitGame));
    }

    /**
     * Method that exits the game and shuts down the program.
     */
    public void exitGame() {
        //Should in future implementations use a
        //Save game method that saves the players progress
        frame.dispose();
        running = false;
    }

    /**
     * When the escape key is pressed it calls
     * the exitGame method
     *
     * @param event
     */
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            exitGame();
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }

    /**
     * Returns game
     *
     * @return game
     */
    Game getGame() {
        return game;
    }
}
