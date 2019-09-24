package view;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Screen {

    private GraphicsDevice vc;

    /**
     * Constructor; sets vc to the default "Screen Device" (GPU)
     */
    public Screen() {
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


    }
}
