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
    
    public static int totalKills;
    public int getTotalKills() {return this.totalKills;}
    public void incrementTotalKills() {this.totalKills++;}
    
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
    
    private String victorySound = "level_victory.mp3";
    public void setVicstorySound(String sound) {this.victorySound = sound;}
    public String getVictorySound() {return this.victorySound;}
    
    private static int simpleCannonPrice = 50;
    
    int worldTime = 0;

    boolean isIntro = false;
    public void setIsIntro(boolean intro) { this.isIntro = intro;}
    boolean isPlaying = false;
    
    boolean isFinalLevel = false;
    public void setIsFinal(boolean isFinal) {this.isFinalLevel = isFinal;}
    
    private static final GreenfootSound ostSound = new GreenfootSound("Bleeping Demo.mp3");
    
    public MyWorld(String [] map)
    {    
        super(840, 600, 1);
                
        ostSound.stop();       
        setWorldMap(map);
        addPath();
        
            
        
        Menu menu = new Menu();
        addObject(menu,720,300);
        addObject(new MoneyShowable(this), 720, 30);
        addObject(new HPShowable(this), 720, 70);
        addObject(new WaveShowable(this, 30), 720, 100);
        
        new TurretShop(this);
        
        addObject(new HelpText(), 720, 400);
    }
    
    public void act() {
        isPlaying = true;
        if(isPlaying) {
            ostSound.setVolume(70);
            if (!ostSound.isPlaying()) {
                ostSound.play();
            }
        }
        
        if (isIntro) {
            addObject(new Scoreboard("Welcome to Metro Defense", "A simple Tower Defense game", -1, nextLevel), getWidth()/2, getHeight()/2);
        }
        addTurretByKeyPressed();
        sellTurret();
        checkRemainingEnemies();
        checkHp();
        spawnWave();
    }
    
    
    public void checkHp() {
        if (worldHealth <= 0) {
            addObject(new Scoreboard(totalKills), getWidth()/2, getHeight()/2);
            ostSound.setVolume(20);
            Greenfoot.playSound("game_over.mp3");
            Greenfoot.stop();
        }
    }
    
    GreenfootSound sound = new GreenfootSound(victorySound);
    
    public void checkRemainingEnemies() {
        if (getTotalEnemiesPerLevel() <= 0) {
            String msgToShow = "Level won!";
            if (isFinalLevel) {
                msgToShow = "Congrats you finished the game!";
            }
            addObject(new Scoreboard(msgToShow, totalKills, nextLevel), getWidth()/2, getHeight()/2);
            removeEnemies();
            
            sound.setVolume(90);
            if (!sound.isPlaying()) {
                sound.play();
            }
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
        //if (type == 0) {type = 1;}
        addObject(new Enemy(type, this), spawnX, spawnY);
    }
    
    private void sellTurret() {
        if (Greenfoot.mouseClicked(null) &&
            Greenfoot.getMouseInfo() != null &&
                (Greenfoot.getMouseInfo().getActor() instanceof Turret)) {
            if (Greenfoot.getMouseInfo().getButton() == 3) {
                Turret turretToBeDeleted = (Turret)Greenfoot.getMouseInfo().getActor();
                money += turretToBeDeleted.price() * 0.8;
                removeObject(turretToBeDeleted);
            }
        }
    }
    
    private void addTurretByKeyPressed() {
        if (Greenfoot.isKeyDown("1")) {
            addTurret(1);
        } else if (Greenfoot.isKeyDown("2")) {
            addTurret(2);
        } else if (Greenfoot.isKeyDown("3")) {
            addTurret(3);
        }
        
    }
    
    public void addTurret(int type) {
       
        // not overlapping another actor
        if (Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo() != null && Greenfoot.getMouseInfo().getActor() == null) {
            if (type == 1) {
                addTurret(new SimpleCannon());
            } else if (type == 2) {
                addTurret(new AdvancedCannon());
            } else if (type == 3) {
                addTurret(new SniperCannon());
            }
        }
        
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
        if (worldTime >= 500) { //initial delay
            
            if (getTotalEnemiesPerLevel() > 0) {
                
                if (worldTime < 1500 && worldTime % 45 == 0) {
                    spawnEnemy(1);
                }
                
                if (worldTime % 70 == 0 && worldTime >= 1500) {
                    spawnEnemy(2);
                }
                
                if (worldTime % 80 == 0 && worldTime >= 2500) {
                    spawnEnemy(3);
                }
                
                if (worldTime % 60 == 0 && worldTime >= 3300) {
                    spawnEnemy(Greenfoot.getRandomNumber(2)+1);
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
                
                
                
            }
        }
    }
    
 }
