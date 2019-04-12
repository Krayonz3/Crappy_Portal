/*
 * Crappy Portal was built and designed by Joey Torii and Carlos Andres Vazquez Baur
 */
package rendering;

import Utilities.managers.TextureManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
/**
 
 * @author carlo_000
 */
public class Texture {
    
    private final static Map<String, TextureManager> textMap = new HashMap<String, TextureManager>();
    private TextureManager manager;
    private String fileName;
    
    public Texture(String fileName){
        TextureManager oldTexture = textMap.get(fileName);
        if(oldTexture != null){
            manager = oldTexture;
            manager.addReference();
        } else {
            try{
                manager = new TextureManager(ImageIO.read(new File("./resources/texture/" + fileName + ".png")));              
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void finalize() throws Throwable {
        if(manager.removeReference() && !(fileName.isEmpty())) 
            textMap.remove(fileName);
        super.finalize();
    }
    
    public void render(Graphics g, double x, double y){
        g.drawImage(manager.getImage(), (int) x, (int) y, null);
    }
}
