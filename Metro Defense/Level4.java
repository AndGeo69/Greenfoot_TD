import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends MyWorld
{

    public static final int TILE_SIZE = 60;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    //1 straigth path
    //2 turn down
    //3 turh right
    //4 turn up
    //5 turn left
    
    
     public final static String[] WORLD = {
        "0000000000",
        "1111111120",
        "0000000010",
        "0211111150",
        "0100000000",
        "0311111120",
        "0000000010",
        "0211111150",
        "0100000000",
        "0311111111"
    };
        
    public Level4() {
        super(WORLD);   

        setSpawnX(20);
        setSpawnY((TILE_SIZE * 2) - HALF_TILE_SIZE);
        
        setMoney(200);
        setNewWorldHealth(20);
        setNextLevel(new Level5());
        setVicstorySound("level_victory2.mp3");
    
        setTotalEnemiesPerLevel(120);
     }
    
    public void act() {
        super.act();
    }
}
