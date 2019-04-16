/*
 * Crappy Portal was built and designed by Joey Torii and Carlos Andres Vazquez Baur
 */
package Window;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author carlo_000
 */
public class Crappy_Portal extends JFrame {

    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 4 * 3;
    
    public Crappy_Portal()
    {
        setTitle("CRAPPY PORTAL");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
