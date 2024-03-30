import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{

    public static final int TILE_SIZE = 60;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    //1 straigth path
    //2 turn down
    //3 turh right
    //4 turn up
    //5 turn left
    
    
    public final static String[] WORLD = {
        "2032000000",
        "1011000000",
        "1011000320",
        "1011000110",
        "1011000110",
        "1011000131",
        "1013111400",
        "1010000000",
        "1010000000",
        "3140000000"
    };
        
    public Level3() {
        super(WORLD);   

        setSpawnX(20);
        setSpawnY((TILE_SIZE * 1) - HALF_TILE_SIZE);
        
        setMoney(150);
        setNewWorldHealth(30);
    
        setTotalEnemiesPerLevel(70);
     }
    
    public void act() {
        super.act();
    }
}
