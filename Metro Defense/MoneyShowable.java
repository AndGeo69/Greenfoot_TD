import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MoneyShowable extends Showable {
    public MoneyShowable(MyWorld game) {
        super(game, "$: ");
    }

    public String getValue() {
        return String.valueOf(game.getMoney());
    }

    protected String getLabelText() {
        return "$: ";
    }
}
