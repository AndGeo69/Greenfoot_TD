import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    public static final float FONT_SIZE = 38.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private String message;
    private int score;
    private World nextLevel;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public Scoreboard()
    {
        this(100);
    }   
    
    public Scoreboard(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }
    
    /**
     * Create a score board for the final result.
     */
    public Scoreboard(String msg, int score, World nextLevel)
    {
        this.message = msg;
        this.score = score;
        makeImage(msg, "Score: ", score, nextLevel);
    }

    private void makeImage(String title, String prefix, int score) {
        makeImage(title, prefix, score, null);
    }
    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score, World nextLevel)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = new Font("Arial", true, false, (int)FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 50, 80);
        image.drawString(prefix + score, 50, 150);
        if (nextLevel != null) {
            this.nextLevel = nextLevel;
            image.setColor(Color.GREEN); // Set the color to blue
            image.drawString("Next Level", 50, 250);
            isNextLevelClicked();
        }
        
        setImage(image);
    }
    
    public boolean isNextLevelClicked() {
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null && mouse.getX() >= 270 && mouse.getX() <= 440 && mouse.getY() >= 370 && mouse.getY() <= 400) {
                Greenfoot.setWorld(nextLevel); 
                return true; // Click is within the region of "Next Level" text
            }
        }
        return false;
    }

}
