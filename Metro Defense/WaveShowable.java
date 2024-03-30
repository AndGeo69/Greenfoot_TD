import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveShowable extends Showable
{
    public WaveShowable(MyWorld game, int size) {
        super(game, "Enemies left: ", size);
    }

    public String getValue() {
        return String.valueOf(game.getTotalEnemiesPerLevel() >= 0 ? game.getTotalEnemiesPerLevel() : "0");
    }

    protected String getLabelText() {
        return "Enemies left: ";
    }
}
