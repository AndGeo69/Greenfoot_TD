import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 1; //default, used by SimpleCannon
    public int getDamage() {return this.damage;}
    
    private int speed = 7;  //default, used by SimpleCannon
    public void setSpeed(int speed) {this.speed = speed;}
    
    public Projectile() {}
    
    public Projectile(int damage) {
        this.damage = damage;
    }
    
    public Projectile(int damage, int speed) {
        this.damage = damage;
        this.speed = speed;
    }
    

    public void act()
    {
        move(speed);
        removeOnEdge();
    }
    
    private void removeOnEdge() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
