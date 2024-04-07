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
        int y = 240;
        
        
        
        setImage(getHelpTextImg());
    } 
    
    public GreenfootImage getHelpTextImg() {
        
        int x = 220;
        int y = 240;
        
        GreenfootImage image = new GreenfootImage(x, y);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, x, y);
        image.setColor(new Color(0, 0, 0, 128));
        
        Font font = new Font("Arial", true, false, (int)20);
        image.setFont(font);
        
        image.drawString("To spawn turrets:", 10, 30);
        Font font2 = new Font("Arial", true, false, (int)20);
        image.setFont(font2);
        image.drawString("Hold key '1' / '2' / '3'", 20, 60);
        image.drawString("+", 50, 80);
        image.drawString("click on a tile", 20, 100);
        
        image.drawString("Sell: right click turret", 10, 150);
        image.drawString("80% money back", 30, 170);
        
        Font font3 = new Font("Arial", true, false, (int)18);
        image.setFont(font3);
        image.drawString("Shift + hover for radius", 10, 210);
        return image;
    }
}
