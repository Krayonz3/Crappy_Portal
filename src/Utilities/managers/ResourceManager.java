/*
 * Crappy Portal was built and designed by Joey Torii and Carlos Andres Vazquez Baur
 */
package Utilities.managers;

/**
 *
 * @author carlo_000
 */
public abstract class ResourceManager {
    protected int count = 1;
    
    public void addReference(){
        count++;
    }
    
    public boolean removeReference(){
        count--;
        return count == 0;
    }
    
}
