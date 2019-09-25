package view;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class View {

    private GraphicsDevice vc;

    /**
     * Constructor; sets vc to the default "View Device" (GPU)
     */
    public View() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();

    }

    /**
     * Sets a JFrame to fullscreen
     * @param displayMode Display Settings, Resolution, bit-Depth, Framerate
     * @param window The JFrame to be fullscreened
     */
    public void setFullscreen(DisplayMode displayMode, JFrame window){
        window.setUndecorated(true); /* Remove Title bar etc. */
        window.setResizable(false); /*Remove the ability to change window size */
        vc.setFullScreenWindow(window);

        if(displayMode != null && vc.isDisplayChangeSupported()){
            try{
                vc.setDisplayMode(displayMode);
            }catch(Exception e){}
        }
    }

    public java.awt.Window getWindow(){
        return vc.getFullScreenWindow();
    }

    /**
     * TODO Something to do with trashing the window
     */
    public void restoreScreen(){
        java.awt.Window w = getWindow();
        if(w != null){
            w.dispose();
        }
        vc.setFullScreenWindow(null); /* TODO Why not False? */
    }


    /**
     *
     *
     */
    public void testScreen(){
        JFrame window = new JFrame();
        DisplayMode displayMode = new DisplayMode(1920, 1080,32, 60);
        setFullscreen(displayMode, window);

        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
//                g.setColor(Color.BLACK);
//                g.fillOval(100, 100, 200, 200);
                try {
                    File pathToFile = new File("./resources/background_1.png");
                    Image image = ImageIO.read(pathToFile);
                    g.drawImage(image, 0, 0, 1920, 1080, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    File pathToFile = new File("./resources/player.png");
                    Image image = ImageIO.read(pathToFile);
                    g.drawImage(image, 0, 0, 200, 200, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        canvas.setSize(displayMode.getWidth(), displayMode.getHeight());
        window.add(canvas);
        window.pack();

    }
}
