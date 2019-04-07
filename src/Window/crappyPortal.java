/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

//import Database.*;
//import Player.*;
//import levelOne.*;
//import levelTwo.*;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.PrintStream;

/**
 *
 * @author carlo_000
 */
public class crappyPortal extends Canvas implements Runnable {
    
    public static final String TITLE = "Crappy Portal";
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 4 * 3;
    private boolean         running;
    
    private void tick() {
        
    }
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        } 
        Graphics g;
        g = bs.getDrawGraphics();
        //dtrawing area
        g.setColor(Color.RED);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        /////////////////
        g.dispose();        
        bs.show();
    }
    
    private void start(){
        if(running) 
            return;
        running = true;
        new Thread(this, "crappyPortal-Thread").start();
    }
    
    public void stop(){
        if(!running)
            return;
        running = false; 
        System.exit(0);
    }
    
    @Override
    public void run() {
        double target = 60.0;
        double nanoSecondsPerTick = 1000000000.0 / target;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double unprocessed = 0.0;
        int fps = 0;
        int tps = 0;  
        
        boolean canRender = false;
        
        while(running){
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nanoSecondsPerTick;
            lastTime = now;
            
            if(unprocessed >= 1.0){
                tick();
                unprocessed--;
                tps++;
                canRender = true;
            } else 
                canRender = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if (canRender){
                //render();
                fps++;
            }
            if (System.currentTimeMillis() - 1000 > timer){
                timer += 1000;
                System.out.printf("FPS: %d | TPS: %d \n", fps, tps);
                fps = 0;
                tps = 0;
            }            
        }
        System.exit(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       crappyPortal game = new crappyPortal();
       JFrame frame = new JFrame(TITLE);
       frame.add(game);
       frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       frame.setResizable(false);
       frame.setFocusable(true);
       frame.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e){
               System.err.println("Exiting the game!");
               game.stop();
           }
       });
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.requestFocus();
    }
    
}
