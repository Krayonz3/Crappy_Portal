/*
 * Crappy Portal was built and designed by Joey Torii and Carlos Andres Vazquez Baur
 */
package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.border.Border;
        
/**
 *
 * @author carlo_000
 */
public class Crappy_Portal extends JFrame{
    
    public static final String TITLE = "Crappy Portal";
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 4 * 3;
    public String USER_NAME;  
    //private boolean         running;

    
    public Crappy_Portal() {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
