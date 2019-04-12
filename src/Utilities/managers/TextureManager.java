/*
 * Crappy Portal was built and designed by Joey Torii and Carlos Andres Vazquez Baur
 */
package Utilities.managers;

import java.awt.image.BufferedImage;

/**
 *
 * @author carlo_000
 */
public class TextureManager extends ResourceManager{
    
    private BufferedImage image;
    
    public TextureManager(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage getImage(){
        return image;
    }
}
