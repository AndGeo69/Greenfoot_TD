import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpText extends Actor
{
    public HelpText() {
        
        int x = 220;
        int y = 200;
        
        GreenfootImage image = new GreenfootImage(x, y);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, x, y);
        image.setColor(new Color(0, 0, 0, 128));
        
        Font font = new Font("Arial", true, false, (int)18);
        image.setFont(font);
        //image.setColor(Color.WHITE);
        
        image.drawString("Controlls", 10, 30);
        
        image.drawString("To spawn turrets:", 10, 70);
        Font font2 = new Font("Arial", true, false, (int)18);
        image.setFont(font2);
        image.drawString("Hold '1' or '2'", 40, 110);
        image.drawString("+", 80, 130);
        image.drawString("click on a tile", 40, 150);
        
        setImage(image);
    } 
}
