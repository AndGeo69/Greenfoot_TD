import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HPShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPShowable extends Showable {
    public HPShowable(MyWorld game) {
        super(game, "HP: ");
    }

    public String getValue() {
        return String.valueOf(game.getWorldHealth() >= 0 ? game.getWorldHealth() : 0);
    }

    protected String getLabelText() {
        return "HP: ";
    }
}
