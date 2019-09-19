import controller.KeyInput;
import model.Game;
import view.Screen;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Screen screen = new Screen();
        testScreen(screen);

        KeyInput keyInput = new KeyInput();
        screen.getWindow().addKeyListener(keyInput);
    }

    /**
     *
     * @param screen the "screen" (not the physical screen)
     */
    public static void testScreen(Screen screen){
        JFrame window = new JFrame();
        DisplayMode displayMode = new DisplayMode(1920, 1080,32, 60);
        screen.setFullscreen(displayMode, window);
    }

}
