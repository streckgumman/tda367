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
}
