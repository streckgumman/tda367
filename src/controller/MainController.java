package controller;

import model.Game;
import view.InGameView;
import view.View;

import javax.swing.*;

public class MainController {

    private JFrame frame;
    private final Game game;
    private Controller c;
    private boolean running;

    public MainController() {
        game = new Game();
        frame = new JFrame();
    }

    public void startGame() {

    }

    private void runGame() {
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
}
