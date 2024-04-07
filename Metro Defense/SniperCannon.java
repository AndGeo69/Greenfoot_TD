import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperCannon extends Turret
{
    public int damage() {
        return 3;
    }
    
    public int fireRate() {
        return 35;
    }
    
    public int radius() {
        return 250;
    }
    
    public int price() {
        return 120;
    }
    
    public String soundName() {
        return "sniper1.wav";
    }
}
