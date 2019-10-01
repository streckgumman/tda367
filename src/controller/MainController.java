package controller;

import model.Game;
import view.InGameView;
import view.StartMenuView;
import view.View;

import javax.swing.*;

/**
 * The "overlord" of controllers, responsible for switching which one is active, as well as which view is shown.
 */
public class MainController {

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

        c = new StartMenuController(view, this);
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
        frame.remove(view); //I don't know why this is necessary, but I could not get it to work without first removing the view and then adding it again. /Vargen
        view = new InGameView(game);
        frame.add(view);
        frame.validate(); //Removing the view invalidates the frame, so we need to validate it in order to display it again.

        c = new InGameController(view, game);
        view.addKeyListener(c);
        view.requestFocus(); //This is required in order to register user input again.

    }

}
