import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelIntro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelIntro extends MyWorld
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
        "0000003120",
        "1200001010",
        "0103114010",
        "0101000010",
        "0104115031",
        "0100001000",
        "0100001000",
        "0100001000",
        "0311114000"
    };
    
    
    int remainingEnemies = 0;
    
    public LevelIntro() {
        super(WORLD);   
        setIsIntro(true);
        setSpawnX(20);
        setSpawnY((TILE_SIZE * 3) - HALF_TILE_SIZE);
          
        setMoney(100);
        setNewWorldHealth(30);

        setVicstorySound("level_victory.mp3");
        
        setTotalEnemiesPerLevel(40);
        setNextLevel(new Level1());
     }
    
    public void act() {
        super.act();
    }
}
