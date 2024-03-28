import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorld
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
    
    public Level1() {
        super();   
        Menu menu = new Menu();
        addObject(menu,720,300);
        
        setMoney(100);
        setNewWorldHealth(30);
        setTotalWavesToWinLevel(5);
        setTotalEnemiesPerWave(10);
        setWave(1);
        
        addObject(new MoneyShowable(this), 720, 30);
        addObject(new HPShowable(this), 720, 70);
        addObject(new WaveShowable(this), 720, 100);
        
        
        addPath();
    }
    
    public void act() {
        addTurret(1);
        spawnWave();
        checkHp();
    }
       
    public void spawnWave() {
        
        int currentWave = getWave();
        int enemiesOfWaveRemaining = getTotalEnemiesPerWave();
        
        worldTime++;
        if (worldTime >= 100){
            
            if (currentWave <= getTotalWavesToWinLevel() && enemiesOfWaveRemaining > 0) {
                //if (currentWave == 1) {
                    if (worldTime % 30 == 0) {
                        
                        if (enemiesOfWaveRemaining > 0) { //TODO handle wave spawning
                            spawnEnemy(1);
                            enemiesOfWaveRemaining--;
                        } else {
                            currentWave++;
                            setWave(currentWave);
                        }

                    }
                //}
            }

            
            //if(worldTime < 1000 && worldTime % 50 == 0){
            //    addObject(new Enemy(1, this), 20, 150);
            //}
            //if(worldTime <= 1000 && worldTime % 150 == 0 && worldTime >= 700){
            //     addObject(new Enemy(2, this), 20, 150);
            //}
            //if(worldTime <= 2000 && worldTime % 75 == 0 && worldTime >= 1000){
            //    addObject(new Enemy(3, this), 20, 150);
            //}
        }
    }
    
    private void spawnEnemy(int type) {
        addObject(new Enemy(type, this), 20, 150);
    }
    
    private void addPath() {
        for (int i = 0; i < WORLD.length; i++) {
            for (int j = 0; j < WORLD[i].length(); j++) {
                if (WORLD[j].charAt(i) == '1') {
                    addObject(new Path(true), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
                
                if (WORLD[j].charAt(i) == '2') {
                    addObject(new Path(90), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
                
                if (WORLD[j].charAt(i) == '3') {
                    addObject(new Path(0), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
                
                if (WORLD[j].charAt(i) == '4') {
                    addObject(new Path(270), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
                
                if (WORLD[j].charAt(i) == '5') {
                    addObject(new Path(180), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
                
                
                if (WORLD[j].charAt(i) == '0') {
                    addObject(new InvisibleObstacle(), HALF_TILE_SIZE + i * TILE_SIZE,
                            HALF_TILE_SIZE + j * TILE_SIZE);
                }
            }
        }
    }
}
