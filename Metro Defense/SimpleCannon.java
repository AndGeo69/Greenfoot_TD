import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class SimpleCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleCannon extends Turret
{
    public int damage() {
        return 1;
    }
    
    public int fireRate() {
        return 13;
    }
    
    public int radius() {
        return 100;
    }
    
    public int price() {
        return 50;
    }
    
    public String soundName() {
        return "cannon1.wav";
    }
}
