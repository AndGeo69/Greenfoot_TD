import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Showable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Showable extends Actor {
    protected MyWorld game;

    public Showable(MyWorld game, String text) {
        this.game = game;
        setImage(new GreenfootImage(text + getValue(), 50, Color.WHITE, new Color(0,0,0,0)));
    }

    public abstract String getValue();

    public void act() {
        setImage(new GreenfootImage(getLabelText() + getValue(), 50, Color.WHITE, new Color(0,0,0,0)));
    }

    protected abstract String getLabelText();
}
