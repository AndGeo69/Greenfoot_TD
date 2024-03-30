import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld myGame;
    
    private int movementSpeed;
    private int hp;
    private int level;
    private int pricePerKill;
 
    public Enemy(int level, MyWorld game){
            this.level = level;
            this.myGame = game;
            if(level == 1) {
                setImage("spider.png");
                getImage().scale(40, 40);
                hp = 5;
                movementSpeed = 3;
                pricePerKill = 5;
            }
            else if(level == 2){
                setImage("snake2.png");
                getImage().scale(60, 60);
                hp = 15;
                movementSpeed = 3;
                pricePerKill = 10;
            }
            else if(level == 3){
                setImage("lizard2.png");
                getImage().scale(60, 60);
                hp = 30;
                movementSpeed = 2;
                pricePerKill = 16;
            }
            //else if(level == 4){
            //    setImage("blimp.png");
             //   getImage().scale(100, 100);
             //   hp = 100;
            //}
        }
    
    public void act()
    {
        moveIntoPath();
        hit();

    }
    
    public void moveIntoPath() {
        move(movementSpeed);
        List<Path> path90 = getObjectsAtOffset(-30, 0, Path.class);
        for (Path path: path90) {
            if (path.getStraight() == false && getRotation() == 0) {
                setRotation(path.getTurn());
            }
        }
        
        List<Path> path0 = getObjectsAtOffset(0, -30, Path.class);
        for (Path path: path0) {
            if (path.getStraight() == false && getRotation() == 90) {
                setRotation(path.getTurn());
            }
        }
        
        List<Path> path180 = getObjectsAtOffset(0, 30, Path.class);
        for (Path path: path180) {
            if (path.getStraight() == false && getRotation() == 270) {
                setRotation(path.getTurn());
            }
        }
        
        List<Path> path270 = getObjectsAtOffset(30, 0, Path.class);
        for (Path path: path270) {
            if (path.getStraight() == false && getRotation() == 180) {
                setRotation(path.getTurn());
            }
        }
    }
    
    public void hit() {
        Projectile projectile = (Projectile)getOneIntersectingObject(Projectile.class);
        if (projectile != null) {
            
            hp = hp - projectile.getDamage();
            getWorld().removeObject(projectile);
        }
        
        if (hp < 1) {
            myGame.money += pricePerKill;
            myGame.totalKills++;
            myGame.totalMoneyGained += pricePerKill;
            myGame.setTotalEnemiesPerLevel(myGame.getTotalEnemiesPerLevel() - 1);
            getWorld().removeObject(this);
        } else if (atWorldEdge()) {
            myGame.setNewWorldHealth(myGame.getWorldHealth() - 1);
            getWorld().removeObject(this);
        }
    }
    
    public boolean atWorldEdge() {
        if(getX() < 20 || getX() > getWorld().getWidth() - 240 - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
}
