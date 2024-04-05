import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Turrent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Turret extends Actor
{
    
    public abstract int fireRate();
    public abstract int damage();
    public abstract int radius();
    public abstract int price();
    public abstract String soundName();
    
    private int fireRateInterval = 0;

    public Turret() {
        getImage().scale(60, 60);
    }
    
    public void act()
    {
        enemyDetector();
    }
    
    public void enemyDetector() {
        fireRateInterval++;
        List<Enemy> enemies = getObjectsInRange(radius(), Enemy.class);
        for(Enemy enemy : enemies) {
            this.pointAtObject(enemy);
            if (fireRateInterval > fireRate()) {
                fireRateInterval = 0;
                fireProjectile(enemy.getX(), enemy.getY());
            }
        }
    }
    
    GreenfootSound sound = new GreenfootSound(soundName());
    
    protected void fireProjectile(int targetX, int targetY) {
        
        sound.setVolume(70);
        if (!sound.isPlaying()) {
            sound.play();
        }
        
        Projectile projectile = new Projectile(damage());
        getWorld().addObject(projectile, getX(), getY());
        projectile.turnTowards(targetX, targetY);
    }
    
    public void pointAtObject(Actor c) 
    { 
        setRotation((int)(180*Math.atan2(c.getY()-getY(),c.getX()-getX())/Math.PI) + 90); 
    }
}
