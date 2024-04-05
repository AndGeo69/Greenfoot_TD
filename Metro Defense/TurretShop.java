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
    public TurretShop(MyWorld world) {
        world.addObject(new ImageShowable(new SimpleCannon(), 1), 650, 200);
        world.addObject(new ImageShowable(new AdvancedCannon(), 2), 720, 200);
        world.addObject(new ImageShowable(new SniperCannon(), 3), 790, 200);  
    }
}
