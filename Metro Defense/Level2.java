import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends MyWorld
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
            "0021115010",
            "0010001010",
            "0010004150",
            "0010000000",
            "0010000000",
            "0031120000",
            "0000010000"
    };
        
    public Level2() {
        super(WORLD);   

        setSpawnX(20);
        setSpawnY((TILE_SIZE * 2) - HALF_TILE_SIZE);
        
        setMoney(150);
        setNewWorldHealth(30);
        setNextLevel(new Level3());
        setVicstorySound("level_victory.mp3");
    
        setTotalEnemiesPerLevel(90);
     }
    
    public void act() {
        super.act();
    }
}
