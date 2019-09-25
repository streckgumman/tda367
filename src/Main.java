import controller.KeyInput;
import model.Game;
import view.Screen;


public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Screen screen = new Screen();
        screen.testScreen();



        KeyInput keyInput = new KeyInput();
        screen.getWindow().addKeyListener(keyInput);
    }

}
