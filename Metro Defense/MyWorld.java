import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    public static final int TILE_SIZE = 60;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;
    
    //1 straigth path
    //2 turn down
    //3 turh right
    //4 turn up
    //5 turn left
    // map preset
    // public final static String[] WORLD = {
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //    "0000000000",
    //   "0000000000"
    //};
    
 
    private String[] WORLD;
    public void setWorldMap(String [] map) {this.WORLD = map;}
    
    private World nextLevel;
    public void setNextLevel(World theNextLevel) {this.nextLevel = theNextLevel;}
    
    public int totalKills;
    public int totalMoneyGained;
    
    private int spawnX;
    public void setSpawnX(int x) {this.spawnX = x;}
    
    private int spawnY;
    public void setSpawnY(int y) {this.spawnY = y;}
    
    
    private int totalEnemiesPerLevel;
    public int getTotalEnemiesPerLevel() {return totalEnemiesPerLevel;}
    public void setTotalEnemiesPerLevel(int newTotalEnemiesPerLevel){
        totalEnemiesPerLevel = newTotalEnemiesPerLevel;
    }
    
    private int totalWavesToWinLevel;
    public int getTotalWavesToWinLevel() {return totalWavesToWinLevel;}
    public void setTotalWavesToWinLevel(int newTotalWavesToWinLevel){
        totalWavesToWinLevel = newTotalWavesToWinLevel;
    }
    
    private int wave;
    public int getWave() {return wave;}
    public void setWave(int newWave){
        wave = newWave;
    }
    
    private int worldHealth;
    public int getWorldHealth() {
        return worldHealth;
    }

    public void setNewWorldHealth(int newWorldHealth){
        worldHealth = newWorldHealth;
    }
    
    public int money;
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int newMoney){
        money += newMoney;
    }
    
    private static int simpleCannonPrice = 50;
    
    int worldTime = 0;

    public MyWorld(String [] map)
    {    
        super(840, 600, 1);
         
        Menu menu = new Menu();
        addObject(menu,720,300);
        addObject(new MoneyShowable(this), 720, 30);
        addObject(new HPShowable(this), 720, 70);
        addObject(new WaveShowable(this, 30), 720, 100);
           
        
        setWorldMap(map);
        addPath();
    }
    
    
    public void act() {
        addTurret(1);
        checkRemainingEnemies();
        checkHp();
        spawnWave();
    }
    
    
    public void checkHp() {
        if (worldHealth <= 0) {
            addObject(new Scoreboard(totalKills), getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    public void checkRemainingEnemies() {
        if (getTotalEnemiesPerLevel() <= 0) {
            addObject(new Scoreboard("Level won!", totalKills, nextLevel), getWidth()/2, getHeight()/2);
            removeEnemies();
        }
    }
    
    private void removeEnemies() {
        List<Enemy> remainingEnemies = getObjects(Enemy.class);
        if (remainingEnemies.size() > 0) {
            for (Enemy enemy: remainingEnemies) {
                removeObject(enemy);
            }
        }
    }
    
    public void spawnEnemy(int type, int x, int y) {
        addObject(new Enemy(type, this), x, y);
    }
    
    public void spawnEnemy(int type) {
        addObject(new Enemy(type, this), spawnX, spawnY);
    }
    
    public void addTurret(int type) {
       
        // not overlapping another actor
        if (Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo() != null && Greenfoot.getMouseInfo().getActor() == null) {
            if (type == 1) {
                addCannon();
            }
        }
        
    }
    
    private void addCannon() {
        addTurret(new SimpleCannon());
    }
    
    private void addTurret(Turret turret) {
        if (money >= turret.price()) {
            addObject(turret, getCoordinatesToAddTower(Greenfoot.getMouseInfo().getX()),
                        getCoordinatesToAddTower(Greenfoot.getMouseInfo().getY()));
            money -= turret.price();
        }
        
    }
        
    // TILE_SIZE = 60, 0-59 px / 60 = 0 (java int division) * 60 = 0 + 60 / 2 = 30 
    // topothetish sth mesh tou tile dhladh
    // and clickaroume apo 60-129 / 60 = 1,.. round down = 1 * 60 = 60 + 30 = 90, sto miso tou 2o tile
    private int getCoordinatesToAddTower(int mouseClickLocation) {
        return (mouseClickLocation / TILE_SIZE) * TILE_SIZE + HALF_TILE_SIZE;
    }
    
    public void spawnWave() {
        boolean shouldSpawnRandom = false;
        worldTime++;
        if (worldTime >= 100) { //initial delay
            
            if (getTotalEnemiesPerLevel() > 0) {
                
                if (worldTime < 1000 && worldTime % 50 == 0) {
                    spawnEnemy(1);
                }
                
                if (worldTime % 75 == 0 && worldTime >= 1000) {
                    spawnEnemy(2);
                }
                
                if (worldTime % 85 == 0 && worldTime >= 2000) {
                    spawnEnemy(3);
                }
                
                if (worldTime % 75 == 0 && worldTime >= 3000) {
                    spawnEnemy(Greenfoot.getRandomNumber(3));
                }

            }
        }
    }
    
    public void addPath() {
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
