import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveShowable extends Showable
{
    public WaveShowable(MyWorld game) {
        super(game, "Wave: ");
    }

    public String getValue() {
        return game.getWave() + " / " + game.getTotalWavesToWinLevel();
    }

    protected String getLabelText() {
        return "Wave: ";
    }
}
