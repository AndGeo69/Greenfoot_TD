import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public int totalKills;
    public int totalMoneyGained;
    
    private int totalEnemiesPerWave;
    public int getTotalEnemiesPerWave() {return totalEnemiesPerWave;}
    public void setTotalEnemiesPerWave(int newTotalEnemiesPerWave){
        totalEnemiesPerWave = newTotalEnemiesPerWave;
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

    public MyWorld()
    {    
         super(840, 600, 1);    
    }
        
    public void checkHp() {
        if (worldHealth <= 0) {
            addObject(new Scoreboard(totalKills), getWidth()/2, getHeight()/2);
        }
    }
    
    
    public void addTurret(int type) {
       
        // not overlapping another actor
        if (Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null) {
            if (type == 1) {
                addCannon();
            }
        }
        
    }
    
    private void addCannon() {
        if (money >= simpleCannonPrice) {
            addObject(new SimpleCannon(), getCoordinatesToAddTower(Greenfoot.getMouseInfo().getX()),
                        getCoordinatesToAddTower(Greenfoot.getMouseInfo().getY()));
                money -= simpleCannonPrice;
        }
        
    }
        
    // TILE_SIZE = 60, 0-59 px / 60 = 0 (java int division) * 60 = 0 + 60 / 2 = 30 
    // topothetish sth mesh tou tile dhladh
    // and clickaroume apo 60-129 / 60 = 1,.. round down = 1 * 60 = 60 + 30 = 90, sto miso tou 2o tile
    private int getCoordinatesToAddTower(int mouseClickLocation) {
        return (mouseClickLocation / TILE_SIZE) * TILE_SIZE + HALF_TILE_SIZE;
    }
 }
