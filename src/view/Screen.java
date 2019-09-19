package view;
import java.awt.*;
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
}
