import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends MyWorld
{

    public static final int TILE_SIZE = 60;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    ///1 straigth path
    //2 turn down
    //3 turh right
    //4 turn up
    //5 turn left
    // map preset
     public final static String[] WORLD = {
        "1200000000",
        "0320000000",
        "0032000000",
        "0003200000",
        "0000320000",
        "0000032000",
        "0000003200",
        "0000000320",
        "0000000032",
        "0000000003"
    };
    
    
    int remainingEnemies = 0;
    
    public Level5() {
        super(WORLD);   
        
        setSpawnX(20);
        setSpawnY((TILE_SIZE * 1) - HALF_TILE_SIZE);
          
        setMoney(150);
        setNewWorldHealth(20);
        setVicstorySound("level_victory3.mp3");
        setIsFinal(true);
        
        setTotalEnemiesPerLevel(130);
     }
    
    public void act() {
        super.act();
    }
}
