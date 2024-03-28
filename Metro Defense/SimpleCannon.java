import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class SimpleCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleCannon extends Actor
{
    private int radius = 100;
    private int fireRate = 0;
    
    public SimpleCannon() {
        getImage().scale(60, 60);
    }
    
    public void act()
    {
        enemyDetector();
    }
    
    public void enemyDetector() {
        fireRate++;
        List<Enemy> enemies = getObjectsInRange(radius, Enemy.class);
        for(Enemy enemy : enemies) {
            if (fireRate > 9) {
                fireRate = 0;
                Projectile projectile = new Projectile();
                getWorld().addObject(projectile,getX(), getY());
                projectile.turnTowards(enemy.getX(), enemy.getY());
                this.turnTowards(enemy.getX() / 2, enemy.getY() / 2);
            }
        }
    }
}
