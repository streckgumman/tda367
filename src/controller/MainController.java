package controller;

import model.Game;
import view.InGameView;
import view.StartMenuView;
import view.View;

import javax.swing.*;

public class MainController {

    private JFrame frame;
    private View view;
    private final Game game;

    private Controller c;
    private boolean running;

    private int windowWidth;
    private int windowHeight;

    public MainController() {
        game = new Game();
        frame = new JFrame();

        windowWidth = 1920; //For now the width and height is 1920x1080, but it could easily take an argument from settings instead
        windowHeight = 1080;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        frame.add(view = new StartMenuView());


        frame.setSize(windowWidth, windowHeight - 100);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

        c = new StartMenuController(view);
        view.addKeyListener(c);

        runGame();
    }

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

    public void switchToIngame() {
        frame.remove(view); //I don't know why this is necessary, but I could not get it to work without first removing the view and then adding it again. /Vargen
        view = new InGameView(game);

        c = new InGameController(view, game);
        view.addKeyListener(c);

        frame.add(view);
        frame.validate();
    }

}
