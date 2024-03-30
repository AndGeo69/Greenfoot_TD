import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;
import java.util.List;

/**
 * Write a description of class TurretShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurretShop extends Actor
{
    public TurretShop() {
        GreenfootImage simpleTurretImage = new SimpleCannon().getImage();
        GreenfootImage simpleTurretImage2 = new AdvancedCannon().getImage();
        
        
        
        setImage(simpleTurretImage);
        setImage(simpleTurretImage2);
        //getWorld().setImage(new GreenfootImage("simple_cannon.png"), 720, 140);        
    }
}
